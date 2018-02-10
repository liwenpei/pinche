package com.gionee.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.minidev.json.JSONObject;

import com.gionee.common.exception.BizException;
import com.gionee.common.utils.SecurityUtils;
import com.gionee.pay.promotion.service.security.impl.SecurityFacadeImpl;

public class TestBaseAction {
	
	//根据is_local_env判断是本地环境还是测试环境
	String url_local="http://localhost:8080/promotion-core/promotionService.do";   //本地环境
	String url_test="http://121.41.108.162:8018/promotion-core/promotionService.do";  //开发环境
	String url_product="http://promotionpay.gionee.com/promotion-core/promotionService.do";  //生产环境
	
	protected String trans_code;
	
	protected String req_sys="0003";
	//local:本地环境,test:测试环境，product：生产环境
	protected String  env="local";
	
	protected String md5Key;
	
	public JSONObject getHeader(){
		Date date =new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyyMMddHHmmss");
		JSONObject jsonReq = new JSONObject(); 
		jsonReq.put("trans_code",trans_code);
		jsonReq.put("req_sys", req_sys);
		jsonReq.put("req_date", sdf.format(date));
		jsonReq.put("req_time", sdf2.format(date));
		return jsonReq;
	}
	public String getUrl(){
		if(this.env.equals("test")){
			return url_test;
		}else if(this.env.equals("product")){
			return url_product;
		}
		return url_local;
	}
	public String getTrans_code() {
		return trans_code;
	}
	public void setTrans_code(String trans_code) {
		this.trans_code = trans_code;
	}
	public String getReq_sys() {
		return req_sys;
	}
	public void setReq_sys(String req_sys) {
		this.req_sys = req_sys;
	}
	public String getEnv() {
		return env;
	}
	public void setEnv(String env) {
		this.env = env;
	}
	
	public String getMd5Key() {
		return md5Key;
	}
	public void setMd5Key(String md5Key) {
		this.md5Key = md5Key;
	}
	public void setMd5sign(JSONObject jsonReq,JSONObject jsonBody){
		try {
			String signContent = SecurityUtils.getAscStr(jsonBody.toJSONString());
			signContent=signContent+"&"+md5Key;
			
			SecurityFacadeImpl security=new SecurityFacadeImpl();
			String sign = security.getMd5(signContent);
			jsonReq.put("sign",sign);
		} catch (BizException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}
