package com.gionee.pay.promotion.core.vo;

import com.gionee.common.vo.BaseVo;

/**
 * @author liwenpei
 *
 * 2016年8月04日
 */
public class SynOrderRspVo extends BaseVo{
	
	/**
	 * 赞助商名称
	 */
	private String sponsor_desc;
	
	/**
	 * 活动描述
	 */
	private String activity_desc;
	/**
	 * 分享描述
	 */
	private String share_desc;
	/**
	 * 分享文案
	 */
	private String share_statement;
	/**
	 * 分享图片地址
	 */
	private String share_pic_url;
	/**
	 * 分享链接
	 */
	private String share_url;
	
	/**
	 * 赠送金额**/
	private String amount;
	
	public String getSponsor_desc() {
		return sponsor_desc;
	}
	public void setSponsor_desc(String sponsor_desc) {
		this.sponsor_desc = sponsor_desc;
	}
	public String getActivity_desc() {
		return activity_desc;
	}
	public void setActivity_desc(String activity_desc) {
		this.activity_desc = activity_desc;
	}
	public String getShare_desc() {
		return share_desc;
	}
	public void setShare_desc(String share_desc) {
		this.share_desc = share_desc;
	}
	public String getShare_statement() {
		return share_statement;
	}
	public void setShare_statement(String share_statement) {
		this.share_statement = share_statement;
	}
	public String getShare_pic_url() {
		return share_pic_url;
	}
	public void setShare_pic_url(String share_pic_url) {
		this.share_pic_url = share_pic_url;
	}
	public String getShare_url() {
		return share_url;
	}
	public void setShare_url(String share_url) {
		this.share_url = share_url;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	 
	
	

}
