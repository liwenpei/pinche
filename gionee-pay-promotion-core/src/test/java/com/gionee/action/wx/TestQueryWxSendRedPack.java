package com.gionee.action.wx;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.net.ssl.SSLContext;

import net.minidev.json.JSONObject;
import net.minidev.json.JSONStyle;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.gionee.common.TestBaseAction;
import com.gionee.common.utils.CommonUtil;
import com.gionee.common.utils.MD5Util;

/**
 * @author dingyw
 *
 * 2016年7月27日
 */
public class TestQueryWxSendRedPack extends TestBaseAction{
	
	public void execute() {
		//是否采用本地环境还是测试环境
		this.setEnv("local");
		String url=this.getUrl();
		
		this.setTrans_code("180002");
		JSONObject jsonReq = this.getHeader();
		
		JSONObject jsonBody = new JSONObject();
		
		jsonBody.put("app_id", "123456789");
		jsonReq.put("body", jsonBody);
		
		String req_plain=jsonReq.toJSONString(JSONStyle.NO_COMPRESS);
		System.out.println(req_plain);
	try {
		url = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack";
        //微信api提供的参数
        String nonce_str = CommonUtil.getUUID();
        System.out.println("nonce_str:"+nonce_str);
        String wxappid = "wxb3f0e6db6e77ec11";  
        String mch_id =   "1351917501";
     	String day=new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
     	String tenNum = (Calendar.getInstance().getTimeInMillis()+"").substring(3);
        String mch_billno = mch_id + day + tenNum;
        String send_name = "11111";
        String re_openid = "oTmxdt005R6whZs0HvTLAoJSI0_w";//"oTmxdt4g_6WLh_k7kdUayKOAJj3g";"oTmxdt_KMXK0nDSVEQuRVdb3VrSs";//
        String total_amount = "100";
        String total_num = "1";
        String wishing = "222222";
        String client_ip = "192.168.0.1";
        String act_name = "33333";
        String remark = "4444444";
        SortedMap<String,String> parameters = new TreeMap<String,String>();  
        parameters.put("mch_billno", mch_billno);
        parameters.put("mch_id", mch_id);
        parameters.put("wxappid", wxappid);
        parameters.put("send_name", send_name);
        parameters.put("re_openid", re_openid);
        parameters.put("total_amount", total_amount);
        parameters.put("total_num", total_num);
        parameters.put("wishing", wishing);
        parameters.put("client_ip", client_ip);  
        parameters.put("act_name", act_name);  
        parameters.put("remark", remark);
        parameters.put("nonce_str", nonce_str);
        String characterEncoding = "UTF-8";  
        String sign = createSign(characterEncoding,parameters); 
        StringBuilder content = joinKeyAndValue(parameters);
        String postData = getPostData(content,sign);
		
		String response= clientCustonSSL(url, postData,"E:/共享资源/张智/apiclient_cert.p12",mch_id);//AmigoHttpUtils.post(url, req_plain);//
        
		System.out.println("response:"+response);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}
	
	private static String getPostData(StringBuilder content, String sign) {
		content.insert(0, "<xml>");
		content.append("<sign>" + sign + "</sign></xml>");
		return content.toString();
	}
	
	public static void main(String[] args) {
		TestQueryWxSendRedPack t=new TestQueryWxSendRedPack();
		t.execute();
 
	}
	
	private static StringBuilder joinKeyAndValue(SortedMap<String, String> packageParams)
			throws UnsupportedEncodingException {
		StringBuilder content = new StringBuilder(1024);
		Set<Entry<String, String>> paramSet = packageParams.entrySet();
		Iterator<Entry<String, String>> iterator = paramSet.iterator();
		while (iterator.hasNext()) {
			Map.Entry entry = iterator.next();
			String k = (String) entry.getKey();
			String v = (String) entry.getValue();
			content.append("<" + k + ">" + v + "</" + k + ">");
		}
		return content;
	}
	
	private String clientCustonSSL(String url,String data,String cert_path,String password) throws ClientProtocolException, IOException, KeyManagementException,
	UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, CertificateException{
		KeyStore keyStore  = KeyStore.getInstance("PKCS12");
		FileInputStream instream = new FileInputStream(new File(cert_path));//"E:/共享资源/张智/apiclient_cert.p12"
		 keyStore.load(instream, password.toCharArray()); 
		 instream.close();
		SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, password.toCharArray()).build();
		  SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext,new String[] { "TLSv1" },null,
		 SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
		CloseableHttpClient httpclient = HttpClients.custom() .setSSLSocketFactory(sslsf) .build();
		        HttpPost httpost = new HttpPost(url);  
		        httpost.addHeader("Connection", "keep-alive");
		        httpost.addHeader("Accept", "*/*");
		        httpost.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		        httpost.addHeader("Host", "api.mch.weixin.qq.com");
		        httpost.addHeader("X-Requested-With", "XMLHttpRequest");
		        httpost.addHeader("Cache-Control", "max-age=0");
		        httpost.addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0) ");
		        httpost.setEntity(new StringEntity(data, "UTF-8"));
		        CloseableHttpResponse response = httpclient.execute(httpost);
		         HttpEntity entity = response.getEntity();
		         String jsonStr = EntityUtils .toString(response.getEntity(), "UTF-8");
		          EntityUtils.consume(entity);
		          
		          return jsonStr;
	}
	
	 private static String Key =  "e49c3fe9004c40858a1f104393d6d829";
	public static String createSign(String characterEncoding,SortedMap<String,String> parameters){  
        StringBuffer sb = new StringBuffer();  
        Set es = parameters.entrySet();//所有参与传参的参数按照accsii排序（升序）  
        Iterator it = es.iterator();  
        while(it.hasNext()) {  
            Map.Entry entry = (Map.Entry)it.next();  
            String k = (String)entry.getKey();  
            Object v = entry.getValue();  
            if(null != v && !"".equals(v)   
                    && !"sign".equals(k) && !"key".equals(k)) {  
                sb.append(k + "=" + v + "&");  
            }  
        }  
        sb.append("key=" + Key);  
        String sign = MD5Util.MD5Encode(sb.toString(), characterEncoding).toUpperCase();  
        return sign;  
    } 

}
