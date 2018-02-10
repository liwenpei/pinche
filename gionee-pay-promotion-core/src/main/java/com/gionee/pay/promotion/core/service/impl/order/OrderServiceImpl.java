/**
 * 
 */
package com.gionee.pay.promotion.core.service.impl.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gionee.common.constant.CommonConstant;
import com.gionee.common.exception.BizException;
import com.gionee.common.exception.NotRollBackBizException;
import com.gionee.common.utils.CommonUtil;
import com.gionee.pay.promotion.core.dao.mapper.PayPromotionCoreOrderTabMapper;
import com.gionee.pay.promotion.core.service.order.OrderService;
import com.gionee.pay.promotion.core.service.txn.OrderTxnService;
import com.gionee.pay.promotion.core.vo.models.PayPromotionCoreOrderTab;
import com.gionee.pay.promotion.core.vo.models.PayPromotionCoreTxnLogTab;
import com.gionee.pay.promotion.core.vo.models.PayPromotionCoreWxRedPackWithActTab;
import com.gionee.pay.promotion.service.PromotionCoreWxRedPackService;

/**
 * @author liwenpei
 *
 */
@Service
public class OrderServiceImpl implements OrderService{
	Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	OrderTxnService txnService;

	@Autowired
	PromotionCoreWxRedPackService wxRedPackService;
	
	/**
	 * 数据库层
	 */
	@Autowired
	protected PayPromotionCoreOrderTabMapper orderMapper;
	
	private int insertOrderTab(PayPromotionCoreOrderTab orderTab){
		orderTab.setLast_upd_time(new Date());
		log.info("OrderServiceImpl - insertOrderTab() - PayPromotionCoreOrderTab={}", orderTab);
		return orderMapper.insert(orderTab);
	}
	
	@Override
	public int updateOrderTab(PayPromotionCoreOrderTab order) throws BizException {
		order.setLast_upd_time(new Date());
		return orderMapper.updateByPrimaryKey(order);
	}
	
	@Override
	public int queryCountByReqOrderNo(String req_order_no) throws BizException {
		if (StringUtils.isBlank(req_order_no)) {
			throw new BizException("请求订单号不能为空!");
		}
		return txnService.selectCountByOrderNo(req_order_no);
	}

	@Override
	public List<PayPromotionCoreOrderTab> txn_initOrders(PayPromotionCoreTxnLogTab txn) throws BizException,NotRollBackBizException{
		txn.setStatus(CommonConstant.TXN_LOG_STATUS.DEALING.getValue()); // 事务处理中
		
		List<PayPromotionCoreOrderTab> orderList = new ArrayList<PayPromotionCoreOrderTab>();
		List<PayPromotionCoreWxRedPackWithActTab> redPackAndActs = wxRedPackService.getActAndPactInfo(txn);//获取有效活动中的有效红包
		
		if(redPackAndActs != null && redPackAndActs.size() > 0){
			//找到有效赠送红包，生成当前内部订单
			PayPromotionCoreOrderTab order = null;
			for(PayPromotionCoreWxRedPackWithActTab redPack : redPackAndActs){
				// 生成流水,流水1：status:初始化
				//初始化内部订单,数据部分
				txn.setInt_order_status(CommonConstant.ORDER_STATUS.INIT.getValue());
				txn.setPack_status(CommonConstant.RED_PACK_STATUS.PREPARE.getValue());//设置红包状态是成功状态进行锁定
				txnService.initOrderInfo(txn,redPack);//初始化流水
				
				txnService.insertTxnLogTab(txn);//记录初始化流水订单
				int updateNum = wxRedPackService.updateRedPack(txn);
				
				if(updateNum > 0 ){
					log.info("成功生成流水  ->PayPromotionCoreTxnLogTab {}" + txn);
					//订单进入准备状态
					txn.setInt_order_status(CommonConstant.ORDER_STATUS.PREPARE.getValue());
					
					txnService.insertTxnLogTab(txn);//记录准备发送红包流水订单
				}else{
					txn.setPack_status(CommonConstant.RED_PACK_STATUS.FAIL.getValue());
					txn.setFail_reason("红包已经被占用，当前流水生成失败");
					log.info("红包已经被占用，当前流水生成失败  ->PayPromotionCoreTxnLogTab {}" + txn);
					
					txn.setInt_order_status(CommonConstant.ORDER_STATUS.FAIL.getValue());
					txnService.insertTxnLogTab(txn);//记录失败流水订单
				}
				
				order = this.generateIntOrderTrade(txn);//根据事务生成订单
				
				orderList.add(order);
			}
		}
		
		return orderList;
	}
	
	@Override
	public void createOrders(List<PayPromotionCoreOrderTab> orders) throws BizException,NotRollBackBizException {
		if(orders != null && orders.size()>0){
			for(PayPromotionCoreOrderTab order : orders){				
				this.insertOrderTab(order);	
			}
		}
	}
	
	/**
	 * @author liwenpei
	 * @category 生成流水订单
	 */
	private PayPromotionCoreOrderTab generateIntOrderTrade(PayPromotionCoreTxnLogTab txn){
		PayPromotionCoreOrderTab orderTab = new PayPromotionCoreOrderTab();
		orderTab.setInt_trade_no(txn.getInt_trade_no());//流水号
		orderTab.setInt_order_no(txn.getInt_order_no());
		orderTab.setCreate_date(txn.getInt_order_date());
		orderTab.setCreate_time(txn.getInt_order_time());
		orderTab.setInt_txn_no(txn.getInt_txn_no());
		orderTab.setInt_txn_date(txn.getInt_txn_date());
		orderTab.setInt_txn_time(txn.getInt_txn_time());
		//修改赠送红包标志位
		orderTab.setStatus(txn.getInt_order_status());
		//生成内部订单信息
		orderTab.setActivity_name(txn.getActivity_name());
		orderTab.setActivity_no(txn.getActivity_no());
		orderTab.setAmount(txn.getAmount());
		orderTab.setAuditor(txn.getAuditor());
		orderTab.setBusi_type(txn.getBusi_type());
		orderTab.setCreate_date(txn.getInt_order_date());
		orderTab.setGift_trans_amt(txn.getGift_trans_amt());
		orderTab.setGift_type(txn.getGift_type());
		orderTab.setOperator(txn.getOperator());
		orderTab.setOutOrderNo(txn.getOutOrderNo());
		orderTab.setPay_channel(txn.getPay_channel());
		orderTab.setPay_create_time(txn.getPay_create_time());
		orderTab.setPay_trans_time(txn.getPay_trans_time());
		orderTab.setPhone_no(null);
		orderTab.setPlatform_type(txn.getPlatform_type());
		orderTab.setProduct_id(null);
		orderTab.setReq_order_no(txn.getOrder_no());
		orderTab.setReq_trade_no(txn.getTradeNo());
		orderTab.setThirdTransactionNo(txn.getThirdTransactionNo());
		orderTab.setTrans_type(txn.getTrans_type());
		orderTab.setUser_id(txn.getUser_id());
		orderTab.setWechat_open_id(txn.getWechat_open_id());
		orderTab.setApp_id(txn.getApp_id());
		orderTab.setMerchant_id(txn.getMerchant_id());
		orderTab.setPackage_seq_id(CommonUtil.stringToInt(txn.getPackage_seq_id()));
        orderTab.setMch_billno(txn.getMch_billno());
        orderTab.setErr_code(txn.getErr_code());
        orderTab.setSend_listid(txn.getSend_listid());
		orderTab.setWish_desc(txn.getWish_des());
		orderTab.setSponsor(txn.getSponsor());
		orderTab.setClient_ip(txn.getClient_ip());
		orderTab.setActivity_desc(txn.getActivity_desc());
		orderTab.setShare_statement(txn.getShare_statement());
		orderTab.setShare_desc(txn.getShare_desc());
		orderTab.setShare_pic_url(txn.getShare_pic_url());
		orderTab.setShare_url(txn.getShare_url());
		return orderTab;
	}

	@Override
	public List<PayPromotionCoreOrderTab> queryPrepareOrders() throws BizException {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("status", CommonConstant.ORDER_STATUS.PREPARE.getValue());
		return orderMapper.selectAllListByParams(params, " merchant_id,wechat_open_id,status ");
	}



}
