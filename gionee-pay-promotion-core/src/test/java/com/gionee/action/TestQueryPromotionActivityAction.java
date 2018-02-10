package com.gionee.action;

import net.minidev.json.JSONObject;
import net.minidev.json.JSONStyle;

import com.gionee.common.TestBaseAction;
import com.gionee.common.utils.AmigoHttpUtils;

/**
 * @author dingyw
 *
 * 2016年7月27日
 */
public class TestQueryPromotionActivityAction extends TestBaseAction{
	
	public void execute() {
		//是否采用本地环境还是测试环境
		this.setEnv("local");
		String url=this.getUrl();
		
		this.setTrans_code("180001");
		JSONObject jsonReq = this.getHeader();
		
		JSONObject jsonBody = new JSONObject();
		
		jsonBody.put("app_id", "6B85E9B116AC4039B6E05E68F0486A95");
		jsonReq.put("body", jsonBody);
		
		String req_plain=jsonReq.toJSONString(JSONStyle.NO_COMPRESS);
		System.out.println(req_plain);
	try {
		String response=AmigoHttpUtils.post(url, req_plain);
		System.out.println("response:"+response);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}
	public static void main(String[] args) {
		TestQueryPromotionActivityAction t=new TestQueryPromotionActivityAction();
		t.execute();
	
	}

}
