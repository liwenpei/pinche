package com.gionee.pay.promotion.core.vo;

import com.gionee.pay.promotion.core.vo.req.ReqSynOrderVo;

/**
 * @author dingyw
 *
 * 2016年7月27日
 */
public class SynOrderVo extends ReqSynOrderVo{
	
	/**
	 * 归属平台类型
	 * */
	private String platform_type;
	
	/**
	 * 客户端ip*/
	private String client_ip;
	
	public String getClient_ip() {
		return client_ip;
	}

	public void setClient_ip(String client_ip) {
		this.client_ip = client_ip;
	}

	public String getPlatform_type() {
		return platform_type;
	}

	public void setPlatform_type(String platform_type) {
		this.platform_type = platform_type;
	}



}
