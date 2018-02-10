package com.gionee.common;

import com.gionee.common.exception.BizException;
import com.gionee.pay.promotion.service.security.impl.SecurityFacadeImpl;

public class TestMD5 extends TestBaseAction{
	
	public static void main(String[] args) throws BizException {
		
		String signContent="hello";
		SecurityFacadeImpl security=new SecurityFacadeImpl();
		String sign = security.getMd5(signContent);
		System.out.println(sign);
	}	

}
