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
public class TestSynOrderByPostAction extends TestBaseAction{
	
	public void execute() {
		//是否采用本地环境还是测试环境
		this.setEnv("local");
		String url=this.getUrl();
		
		this.setMd5Key("promotionKey");
		this.setTrans_code("170001");
		JSONObject jsonReq = this.getHeader();
		
		JSONObject jsonBody = new JSONObject();
		/*
		 * body":{"thirdTransactionNo":"4003732001201608191724834823",
		 * "tradeNo":"57b6c8b70cf2603b1595090f1","third_user_id":"oTmxdt_i70zUesMZCk455KHBhV64",
		 * "order_no":"57b6c8af0cf2c0d97d18fc10","amount":"0.05","mch_id":"1351917501",
		 * "trans_time":"2016-08-19 16:52:07.0","tran_type":"2",
		 * "outOrderNo":"50b36e69c5ff1471596743600",
		 * "create_time":"2016-08-19 16:52:23.0",
		 * "pay_channel":"108","
		 * app_id":"95EF8D9BCDE24EE99C25465510F39FF6",
		 * "user_id":"5B29300167134B38AE7A02C59AD738BE"},
		 */
		jsonBody.put("order_no", "1234567892"/*CommonUtil.getUUID()*/);
		jsonBody.put("tradeNo", "57b6c8b70cf2603b1595090f1");
		jsonBody.put("thirdTransactionNo", "4003732001201608191724834823");
		jsonBody.put("pay_channel", "1081");
		jsonBody.put("amount", "1.1");
		jsonBody.put("app_id", "0010B01FE62744188AEE99DC96CF9259");//我的
		//jsonBody.put("app_id", "6B85E9B116AC4039B6E05E68F0486A92");//肖芬
		jsonBody.put("outOrderNo", "50b36e69c5ff1471596743600");
		jsonBody.put("tran_type", "2");
		jsonBody.put("user_id", "5B29300167134B38AE7A02C59AD738BE");
		jsonBody.put("mch_id", "1351917501");
		jsonBody.put("third_user_id", "oTmxdt005R6whZs0HvTLAoJSI0_w");
		jsonBody.put("create_time", "20160819172012");
		jsonBody.put("trans_time",  "20160819172012");
		
		jsonReq.put("body", jsonBody);
		
		this.setMd5sign(jsonReq, jsonBody);
		
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
		TestSynOrderByPostAction t=new TestSynOrderByPostAction();
		t.execute();
	}

}
