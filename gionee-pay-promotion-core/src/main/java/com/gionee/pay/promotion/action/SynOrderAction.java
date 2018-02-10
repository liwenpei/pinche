package com.gionee.pay.promotion.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gionee.common.action.AbsBaseAction;
import com.gionee.common.constant.CommonConstant;
import com.gionee.common.exception.BizException;
import com.gionee.common.exception.NotRollBackBizException;
import com.gionee.common.msg.MsgReqHeaderVo;
import com.gionee.common.msg.ReqMsgVo;
import com.gionee.common.msg.RspMsgVo;
import com.gionee.common.vo.BaseMsgVo;
import com.gionee.pay.promotion.core.service.order.OrderPayService;
import com.gionee.pay.promotion.core.service.order.OrderService;
import com.gionee.pay.promotion.core.vo.SynOrderListRspVo;
import com.gionee.pay.promotion.core.vo.SynOrderVo;
import com.gionee.pay.promotion.core.vo.models.PayPromotionCoreOrderTab;
import com.gionee.pay.promotion.core.vo.models.PayPromotionCoreTxnLogTab;
import com.gionee.pay.promotion.service.QueryMerchantService;
import com.gionee.pay.promotion.service.synOrder.check.OrderServiceCheckFacade;
import com.gionee.pay.promotion.service.synOrder.check.SynOrderCheckService;

/**
 * 同步订单数据
 * @author dingyw
 *
 * 2016年7月27日
 */
@Service("synOrderAction")
public class SynOrderAction extends AbsBaseAction<BaseMsgVo>{
	
	Logger log = LoggerFactory.getLogger(getClass());

	/**
	 * 校验订单
	 */
	@Autowired
	OrderServiceCheckFacade orderServiceCheckFacade;
	
	/**
	 * 校验层
	 */
	@Autowired
	SynOrderCheckService synOrderCheckService;
	
	@Autowired
	QueryMerchantService queryMchService;
	
	@Autowired  
	OrderService orderService;
	
	@Autowired
	OrderPayService orderPayService;
	@Override
	public BaseMsgVo execute(BaseMsgVo msgVo) throws BizException , NotRollBackBizException{
		ReqMsgVo reqMsg=(ReqMsgVo)msgVo;//获取vo
		log.info("同步订单数据：SynOrderAction-->"+msgVo);

		MsgReqHeaderVo headerVo = reqMsg.getHeader();
		SynOrderVo vo = (SynOrderVo)reqMsg.getBody();
		
		// 校验权限及token
		commomServiceCheckFacade.commonCheck(headerVo);// 不需要校验user_token
			
		//检查输入参数
		commomServiceCheckFacade.checkInput(vo);
		
		//检查重复订单
		orderServiceCheckFacade.checkOrder(vo); // 校验订单
		
		//校验签名
		synOrderCheckService.checkSign(reqMsg);
		
		vo.setClient_ip(headerVo.getIp());
		log.info("开始创建订单并支付：SynOrderAction-->" + vo);
		
		RspMsgVo result = new RspMsgVo();
		SynOrderListRspVo body = this.createOrder(vo);
		result.setBody(body);
		//返回创建订单成功
		log.info("result->"+result);
		
		return result;
	}
	
	private SynOrderListRspVo createOrder(SynOrderVo vo)throws BizException,NotRollBackBizException{
		
		//获取appid对应的平台信息
		vo.setPlatform_type(queryMchService.getPlatformInfo(vo.getApp_id()));
		//初始化事务
		PayPromotionCoreTxnLogTab txn = orderTxnService.txn_initial(vo);
		SynOrderListRspVo result = null;
		
		List<PayPromotionCoreOrderTab> orders=new ArrayList<PayPromotionCoreOrderTab>();
		//核心流程
		try {
			//初始化订单
			if(CommonConstant.PAY_CHANNEL.WECHATPAY.getValue().equals(vo.getPay_channel())){ //保留扩展，微信支付时进行营销活动过滤
				orders = orderService.txn_initOrders(txn);
			}
			//创建订单
			orderService.createOrders(orders);
			//支付订单
			result = orderPayService.createPayOrders(txn, orders);
			
			orderTxnService.txn_successTxn(txn); // 将事务置成功
		}catch(NotRollBackBizException e){
			e.printStackTrace();
			log.error(e.getMessage(), e);
			orderTxnService.txn_failTxn(txn,e); // 将事务置为失败
			throw new BizException(e.getRsp_code(),e.getMessage());//将异常重新抛出
		}catch (BizException e) {
			e.printStackTrace();
			log.error(e.getMessage(), e);
			orderTxnService.txn_failTxn(txn,e); // 将事务置为失败
			throw new BizException(e.getRsp_code(),e.getMessage());//将异常重新抛出
		}
		
		return result;
	}

	@Override
	public BaseMsgVo getMsg(JSONObject json) throws Exception {
		log.info("getVoFromJson:"+json);
		return this.getMsgVo(json, SynOrderVo.class);
	}
	

}
