package com.gionee.pay.promotion.core.vo.req;

import com.gionee.common.vo.BaseVo;

/**
 * @author dingyw
 *
 * 2016年8月19日
 */
public class ReqSynOrderVo  extends BaseVo{
	
	/**
	 * 订单号
	 */
	protected String order_no;
	
	/**
	 * 支付流水号
	 */
	protected String tradeNo;
	/**
	 * 第三方支付的流水号
	 */
	protected String thirdTransactionNo;
	/**
	 * 支付渠道 A币支付:100 ALIPAY:101 TENPAY:103 WECHATPAY:108 VOUCHER:204
	 */
	protected String pay_channel;
	/**
	 * 交易金额
	 */
	protected String amount;
	/**
	 * app_id
	 */
	protected String app_id;
	/**
	 * 商户ID*/
	protected String mch_id;
	/**
	 * 外部订单号
	 */
	protected String outOrderNo;
	/**
	 * 交易类型
		*1：充值
		*2：消费
		*3：充值并消费（后续扩展）
	 */
	protected String tran_type;

	/**
	 * 用户ID
	 */
	protected String user_id;
	/**
	 * 第三方用户ID*/
	protected String third_user_id;
	/**
	 * 订单时间 格式（yyyyMMddhhmmss）
	 */
	protected String create_time;
	
	/**
	 * 交易时间 格式（yyyyMMddhhmmss）
	 */
	protected String trans_time;

	public String getOrder_no() {
		return order_no;
	}

	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getThirdTransactionNo() {
		return thirdTransactionNo;
	}

	public void setThirdTransactionNo(String thirdTransactionNo) {
		this.thirdTransactionNo = thirdTransactionNo;
	}

	public String getPay_channel() {
		return pay_channel;
	}

	public void setPay_channel(String pay_channel) {
		this.pay_channel = pay_channel;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getApp_id() {
		return app_id;
	}

	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getOutOrderNo() {
		return outOrderNo;
	}

	public void setOutOrderNo(String outOrderNo) {
		this.outOrderNo = outOrderNo;
	}

	public String getTran_type() {
		return tran_type;
	}

	public void setTran_type(String tran_type) {
		this.tran_type = tran_type;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getThird_user_id() {
		return third_user_id;
	}

	public void setThird_user_id(String third_user_id) {
		this.third_user_id = third_user_id;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getTrans_time() {
		return trans_time;
	}

	public void setTrans_time(String trans_time) {
		this.trans_time = trans_time;
	}

}
