package com.gionee.pay.promotion.core.service.impl.txn;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gionee.common.constant.CommonConstant;
import com.gionee.common.exception.BizException;
import com.gionee.common.msg.MsgRspHeaderVo;
import com.gionee.common.utils.CommonMsgUtils;
import com.gionee.common.utils.CommonUtil;
import com.gionee.common.utils.TransIdSerial;
import com.gionee.common.utils.VeDate;
import com.gionee.pay.promotion.core.dao.mapper.PayPromotionCoreTxnLogTabMapper;
import com.gionee.pay.promotion.core.service.txn.OrderTxnService;
import com.gionee.pay.promotion.core.vo.SynOrderVo;
import com.gionee.pay.promotion.core.vo.models.PayPromotionCoreActivityTab;
import com.gionee.pay.promotion.core.vo.models.PayPromotionCoreTxnLogTab;
import com.gionee.pay.promotion.core.vo.models.PayPromotionCoreWxRedPackWithActTab;

/**
 * @author liwenpei
 *
 * 2016年09月02日
 */
@Service
public class OrderTxnServiceImpl implements OrderTxnService{
	Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	PayPromotionCoreTxnLogTabMapper txnMapper ;
	
	@Override
	public void txn_successTxn(PayPromotionCoreTxnLogTab txn) {
		// 流水
		txn.setStatus(CommonConstant.TXN_LOG_STATUS.SUCCESS.getValue());
		txn.setRcv_trans_date(new Date());
		txn.setRcv_trans_time(new Date());
		log.info("OrderTxnServiceImpl - pay() - update txn success");
		
		//此处会把external_no,int_order_no一起更新上去
		this.insertTxnLogTab(txn);
	}
	
	@Override
	public void txn_failTxn(PayPromotionCoreTxnLogTab txn, Exception e) {
		// 流水
		txn.setStatus(CommonConstant.TXN_LOG_STATUS.FAILED.getValue());
		txn.setRcv_trans_date(new Date());
		txn.setRcv_trans_time(new Date());

		if (e.getMessage().length() >= 200) {
			txn.setFail_reason(e.getMessage().substring(0, 200)); // 数据限长
		} else {
			txn.setFail_reason(e.getMessage());

		}
		if (StringUtils.isEmpty(txn.getRcv_rsp_code())) {
			txn.setRcv_rsp_code(CommonConstant.RSP_CODE.FAILED.getValue());
		}
		if (StringUtils.isEmpty(txn.getRcv_rsp_desc())) {
			txn.setRcv_rsp_desc(txn.getFail_reason());
		}
		log.info("OrderTxnServiceImpl - pay() - update txn fail");
		this.insertTxnLogTab(txn);
	}
	
	@Override
	public int insertTxnLogTab(PayPromotionCoreTxnLogTab txn){
		txn.setLast_upd_time(new Date());
		int rnt = 0;
		try{
			rnt = txnMapper.insert(txn);
		}catch(Exception e){
			log.info(e.getMessage(),e);
		}
		
		return rnt;
	}

	@Override
	public PayPromotionCoreTxnLogTab txn_initial(SynOrderVo synOrderVo) {
		PayPromotionCoreTxnLogTab txn = new PayPromotionCoreTxnLogTab();
		MsgRspHeaderVo msgRspHeaderVo = CommonMsgUtils.getHeader();
		txn.setInt_txn_no(TransIdSerial.genRandomSeqId());
		txn.setInt_txn_date(new Date());
		txn.setInt_txn_time(new Date());
		txn.setStatus(CommonConstant.TXN_LOG_STATUS.INIT.getValue()); // 初始化订单
		
		if(msgRspHeaderVo != null){
			txn.setRcv_rsp_code(msgRspHeaderVo.getRsp_code());
			txn.setRcv_rsp_desc(msgRspHeaderVo.getRsp_desc());
			txn.setRcv_sys_code(msgRspHeaderVo.getRcv_sys());
			txn.setRcv_trans_date(VeDate.strToDateLong(msgRspHeaderVo.getRcv_date()));
			txn.setRcv_trans_id(msgRspHeaderVo.getRcv_trans_id());
			txn.setRcv_trans_time(VeDate.strToDateLong(msgRspHeaderVo.getRcv_time()));
		}
		if(synOrderVo != null){
			//记录报文信息
			txn.setOrder_no(synOrderVo.getOrder_no()) ;
			txn.setTradeNo(synOrderVo.getTradeNo());
			txn.setThirdTransactionNo(synOrderVo.getThirdTransactionNo());
			txn.setPay_channel(synOrderVo.getPay_channel());
			txn.setAmount(CommonUtil.stringToBigDecimal(synOrderVo.getAmount()));
			txn.setApp_id(synOrderVo.getApp_id());
			txn.setOutOrderNo(synOrderVo.getOutOrderNo());
			txn.setTrans_type(synOrderVo.getTran_type());
			txn.setUser_id(synOrderVo.getUser_id());
			txn.setWechat_open_id(synOrderVo.getThird_user_id());
			txn.setPay_create_time(VeDate.strToDate(synOrderVo.getCreate_time(),"yyyyMMddhhmmss"));
			txn.setPay_trans_time(VeDate.strToDate(synOrderVo.getTrans_time(),"yyyyMMddhhmmss"));
			txn.setMerchant_id(synOrderVo.getMch_id());
			txn.setReq_platform_type(synOrderVo.getPlatform_type());
			txn.setClient_ip(synOrderVo.getClient_ip());
		}
		
		this.insertTxnLogTab(txn);
		return txn;
	}
	
	@Override
	public PayPromotionCoreTxnLogTab txn_activity(PayPromotionCoreTxnLogTab txn,PayPromotionCoreActivityTab actTab) {
		if(actTab != null){
			txn.setActivity_no(actTab.getActivity_no()); 
			txn.setGift_type(actTab.getGift_type());  
			txn.setService_type(actTab.getService_type()); 
		    txn.setActivity_name(actTab.getActivity_name());
		    txn.setPlatform_type(actTab.getPlatform_type()); 
		    txn.setOperator(actTab.getOperator());
		    txn.setAuditor(actTab.getAuditor() );
		    txn.setEffc_time(actTab.getEffc_time());
		    txn.setExpired_time(actTab.getExpired_time());
		    txn.setActivity_status(actTab.getStatus());
		    txn.setSponsor(actTab.getSponsor());
		    txn.setBudget(actTab.getBudget());
		    txn.setQuantity(actTab.getQuantity());
		    txn.setScene(actTab.getScene());
		    txn.setLimited_quantity(actTab.getLimited_quantity());
		    txn.setRule_type(actTab.getRule_type());
		    txn.setRule_param(actTab.getRule_param());
		    txn.setActivity_desc(actTab.getActivity_desc());
		    txn.setShare_statement(actTab.getShare_statement());
		    txn.setShare_desc(actTab.getShare_desc());
		    txn.setShare_pic_url(actTab.getShare_pic_url());
		    txn.setShare_url(actTab.getShare_url());
			
		    this.insertTxnLogTab(txn);
		}
		return txn;
	}

	 

	@Override
	public int selectCountByOrderNo(String req_order_no) {
		return txnMapper.selectCountByOrderNo(req_order_no);
	}

	@Override
	public PayPromotionCoreTxnLogTab initRedPackAndActivity(PayPromotionCoreTxnLogTab txn,
			PayPromotionCoreWxRedPackWithActTab map) {
		if(map != null){
			//红包
			txn.setGift_trans_amt(map.getP_amt());
			txn.setPackage_seq_id(map.getP_package_seq_id());
			
			//活动
			txn.setActivity_no(map.getA_activity_no()); 
			txn.setGift_type(map.getA_gift_type());  
			txn.setService_type(map.getA_service_type()); 
		    txn.setActivity_name(map.getA_activity_name());
		    txn.setPlatform_type(map.getA_platform_type()); 
		    txn.setOperator(map.getA_operator());
		    txn.setAuditor(map.getA_auditor());
		    txn.setEffc_time(map.getA_effc_time());
		    txn.setExpired_time(map.getA_expired_time());
		    txn.setActivity_status(map.getA_status());
		    txn.setSponsor(map.getA_sponsor());
		    txn.setBudget(map.getA_budget());
		    txn.setQuantity(map.getA_quantity());
		    txn.setScene(map.getA_scene());
		    txn.setLimited_quantity(map.getA_limited_quantity());
		    txn.setWish_des(map.getA_wish_desc());
		    txn.setRule_type(map.getA_rule_type());
		    txn.setRule_param(map.getA_rule_param());
		    txn.setActivity_desc(map.getA_activity_desc());
		    txn.setShare_statement(map.getA_share_statement());
		    txn.setShare_desc(map.getA_share_desc());
		    txn.setShare_pic_url(map.getA_share_pic_url());
		    txn.setShare_url(map.getA_share_url());
		    
		   // this.insertTxnLogTab(txn);
		}
		return txn;
	}

	@Override
	public PayPromotionCoreTxnLogTab initOrderInfo(PayPromotionCoreTxnLogTab txnTab,PayPromotionCoreWxRedPackWithActTab tab) {
		if(txnTab != null){
			initRedPackAndActivity(txnTab,tab);//初始化活动信息
			
			if(txnTab.getInt_order_no() == null){
				//整一个事务只有一个订单
				txnTab.setInt_order_no(TransIdSerial.genRandomSeqId());
				txnTab.setInt_order_date(new Date());
				txnTab.setInt_order_time(new Date());
			}
			
			if(CommonConstant.ORDER_STATUS.INIT.getValue().equals(txnTab.getInt_order_status())){
				//刚开始创建流水
				txnTab.setInt_trade_no(TransIdSerial.genRandomSeqId());//流水号
			}
        	
			//this.insertTxnLogTab(txnTab);
		}
		
		return txnTab;
	}
 

	@Override
	public PayPromotionCoreTxnLogTab queryLastTxn(String int_trade_no) throws BizException {
		return txnMapper.selectLastTxnByOrderNo(int_trade_no);
	}

	@Override
	public void txn_taskSuccessTxn(PayPromotionCoreTxnLogTab txn) {
		// 流水
		txn.setStatus(CommonConstant.TXN_LOG_STATUS.TASK_SUCCESS.getValue());
		txn.setRcv_trans_date(new Date());
		txn.setRcv_trans_time(new Date());
		log.info("OrderTxnServiceImpl - pay() - update txn success");
		
		//此处会把external_no,int_order_no一起更新上去
		this.insertTxnLogTab(txn);
	}

	@Override
	public void txn_taskFailTxn(PayPromotionCoreTxnLogTab txn, Exception e) {
		// 流水
		txn.setStatus(CommonConstant.TXN_LOG_STATUS.TASK_FAILED.getValue());
		txn.setRcv_trans_date(new Date());
		txn.setRcv_trans_time(new Date());

		if (e.getMessage().length() >= 200) {
			txn.setFail_reason(e.getMessage().substring(0, 200)); // 数据限长
		} else {
			txn.setFail_reason(e.getMessage());

		}
		if (StringUtils.isEmpty(txn.getRcv_rsp_code())) {
			txn.setRcv_rsp_code(CommonConstant.RSP_CODE.FAILED.getValue());
		}
		if (StringUtils.isEmpty(txn.getRcv_rsp_desc())) {
			txn.setRcv_rsp_desc(txn.getFail_reason());
		}
		log.info("OrderTxnServiceImpl - pay() - update txn fail");
		this.insertTxnLogTab(txn);

	}
}
