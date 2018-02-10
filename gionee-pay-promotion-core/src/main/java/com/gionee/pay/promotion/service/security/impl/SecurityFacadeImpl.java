package com.gionee.pay.promotion.service.security.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gionee.common.exception.BizException;
import com.gionee.common.utils.Md5Utils;
import com.gionee.common.utils.SecurityUtils;
import com.gionee.common.vo.BaseVo;
import com.gionee.pay.promotion.service.security.SecurityFacade;

/**
 * @author dingyw
 *
 * 2016年8月19日
 */
@Service
public class SecurityFacadeImpl implements SecurityFacade{
	
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	/**
	 * md5密钥
	 */
	private String md5_secret_key;

	@Override
	public void verifySign(BaseVo vo,String sign) throws BizException {
		
		if(StringUtils.isEmpty(sign)){
			throw new BizException("签名字段不能为空");
		}
		
		String content=SecurityUtils.getAscStr(vo);
		
		content=content+"&"+md5_secret_key;
		
		String result=Md5Utils.getMd5(content);

		if(!sign.equals(result)){
			throw new BizException("验签失败");
		}
	}

    
	@Override
	public String getSign(BaseVo vo) throws BizException {
		
		String content=SecurityUtils.getAscStr(vo);
		
		log.info("content-->"+content);
		
		content=content+"&"+md5_secret_key;
		
		return Md5Utils.getMd5(content);
		
	}
	@Override
	public String getMd5(String signContent) throws BizException {
		String sign;
		try {
			sign = Md5Utils.getMD5ofStrByUpperCase(signContent);
			return sign;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BizException("签名出错");
		}
	}

	@Override
	public String getMd5(String signContent,String key) throws BizException {
		String sign;
		String content=signContent+"&"+md5_secret_key;
		try {
			sign = Md5Utils.getMd5(content);
			return sign;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BizException("签名出错");
		}
	}
	public String getMd5_secret_key() {
		return md5_secret_key;
	}

	@Value("#{promotion_core_config['md5_secret_key']}")
	public void setMd5_secret_key(String md5_secret_key) {
		this.md5_secret_key = md5_secret_key;
	}
	
}
