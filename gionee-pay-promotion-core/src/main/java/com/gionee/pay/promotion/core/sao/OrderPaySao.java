package com.gionee.pay.promotion.core.sao;

public interface OrderPaySao {
	public void initSendRedPack(String url,String pwd ,String data,String cert_path);
	public String sendRedPack() throws Exception;
}
