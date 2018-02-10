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
public class TestQueryAnnouncementAction extends TestBaseAction{
	
	public void execute() {
		//是否采用本地环境还是测试环境
		this.setEnv("local");
		String url=this.getUrl();
		
		this.setTrans_code("180002");
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
	
	private String[] appIds = {"D31DE77B088341C6989E7391AFACD999","8888","00F59753C2434FEDB77B4DDEF387A493"};
	public static void main(String[] args) {
		
		for(int i=0;i < 1;i++){
			new Thread(){
				@Override
				public void run(){
					System.out.println("开始执行========================");
					long curTime = System.currentTimeMillis();
					TestQueryAnnouncementAction t=new TestQueryAnnouncementAction();
					t.execute();
					long durTime = System.currentTimeMillis() - curTime; 
					System.out.println("使用的时间：" + durTime);
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}.start();
		}
	}

}
