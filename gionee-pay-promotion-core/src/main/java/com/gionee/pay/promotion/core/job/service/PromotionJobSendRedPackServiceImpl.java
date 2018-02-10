package com.gionee.pay.promotion.core.job.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gionee.common.constant.CommonConstant;
import com.gionee.common.exception.BizException;
import com.gionee.common.exception.NotRollBackBizException;
import com.gionee.pay.promotion.core.service.order.OrderService;
import com.gionee.pay.promotion.core.service.order.WxPromotionTransferService;
import com.gionee.pay.promotion.core.service.txn.OrderTxnService;
import com.gionee.pay.promotion.core.vo.WxPromotionTranserRspVo;
import com.gionee.pay.promotion.core.vo.models.PayPromotionCoreOrderTab;
import com.gionee.pay.promotion.core.vo.models.PayPromotionCoreTxnLogTab;
import com.gionee.pay.promotion.service.PromotionCoreWxRedPackService;
import com.gionee.pay.promotion.service.synOrder.check.OrderServiceCheckFacade;

/**
 * @author liwenpei
 *
 *定时根据订单发送红包
 * 2016年10月10日
 */
@Component("promotionJobSendRedPackService")
public class PromotionJobSendRedPackServiceImpl    {

	Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderTxnService txnService;
	
	@Autowired
	private PromotionCoreWxRedPackService redPackService;
	
	@Autowired
	private WxPromotionTransferService promotionService;
	
	@Autowired
	private OrderServiceCheckFacade checkFacade;
	public void synSendRedPack(){
		log.info("【定时器开始触发】promotionJobSendRedPackService");
		try {
			List<PayPromotionCoreOrderTab> orders = orderService.queryPrepareOrders();
			if(orders != null && orders.size() > 0){
				for(PayPromotionCoreOrderTab order : orders){
					log.info("【定时器】promotionJobSendRedPackService 准备赠送红包，订单信息-->>"+order);
					//根据订单得到该订单对应的事务
					PayPromotionCoreTxnLogTab txn = txnService.queryLastTxn(order.getInt_trade_no());
					txn.setId(null);//只获取事务信息，id自动生成
					txn.setStatus(CommonConstant.TXN_LOG_STATUS.TASK_DEALING.getValue());//任务处理中
					try{
						//发送之前检查
						checkFacade.checkPrepareWxSend(txn, order);
						
						createPayOrder(txn,order);
						txnService.txn_taskSuccessTxn(txn); // 将事务置成功
					}catch(Exception e){
						log.info("【线程】赠送红包失败-->>"+e.getMessage());
						txnService.txn_taskFailTxn(txn, e);// 将事务置为失败
					}
				}
			}
			
		} catch (BizException e) {
			log.info("【线程】赠送红包失败-->>"+e.getMessage());
		}
	}
	
	/**
	 * 发送单个红包
	 * @throws NotRollBackBizException 
	 * @throws BizException **/
	public void createPayOrder(PayPromotionCoreTxnLogTab txn ,PayPromotionCoreOrderTab order) throws BizException, NotRollBackBizException{
		WxPromotionTranserRspVo rspVo = null;
		
		rspVo = promotionService.send(order);
				
        if("SUCCESS".equals(rspVo.getReturn_code()) && "SUCCESS".equals(rspVo.getResult_code())){
        	log.info("赠送红包成功,返回信息-->>"+rspVo);
        	//记录事务
        	txn.setInt_order_status(CommonConstant.ORDER_STATUS.SECCESS.getValue());
        	txn.setSign(order.getSign());
        	txn.setNonce_str(order.getNonce_str());
        	txn.setPack_status(CommonConstant.RED_PACK_STATUS.SUCCESS.getValue());
        	txnService.insertTxnLogTab(txn);
        	
        	//标志红包赠送成功
        	redPackService.updateRedPack(txn);
        	
        	//标志订单成功
        	order.setStatus(txn.getInt_order_status());
        	orderService.updateOrderTab(order);
        	
        }else{
        	//赠送红包失败
        	log.info("赠送红包失败,返回信息-->>"+rspVo);
        	
        	//记录事务
        	txn.setInt_order_status(CommonConstant.ORDER_STATUS.FAIL.getValue());
        	txn.setPack_status(CommonConstant.RED_PACK_STATUS.FAIL.getValue());
        	txn.setFail_reason((rspVo == null)?"赠送红包失败":rspVo.getErr_code_des());
        	txnService.insertTxnLogTab(txn);
        	
        	//标志红包赠送失败
        	redPackService.updateRedPack(txn);
        	
        	//内部订单失败
        	order.setStatus(txn.getInt_order_status());
        	orderService.updateOrderTab(order);
        }
        
	}
	

}
