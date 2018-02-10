package com.gionee.pay.promotion.core.sao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import com.gionee.pay.promotion.core.sao.OrderPaySao;

@Service
public class OrderPaySaoImpl implements OrderPaySao {
	private String url;
	private String pwd;
	private String data;
	private String cert_path;
	
	@Override
	public void initSendRedPack(String url,String pwd ,String data,String cert_path){
		this.url = url;
		this.pwd = pwd;
		this.data = data;
		this.cert_path = cert_path;
	}
	
	@Override
	public String sendRedPack() throws Exception {
		
		KeyStore keyStore = KeyStore.getInstance("PKCS12");
		FileInputStream instream = new FileInputStream(new File(cert_path));// "E:/共享资源/张智/apiclient_cert.p12"
		keyStore.load(instream, pwd.toCharArray());
		instream.close();
		SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, pwd.toCharArray()).build();
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1" }, null,
				SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
		CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
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
		String jsonStr = EntityUtils.toString(response.getEntity(), "UTF-8");
		EntityUtils.consume(entity);

		return jsonStr;
	}

 
	
}
