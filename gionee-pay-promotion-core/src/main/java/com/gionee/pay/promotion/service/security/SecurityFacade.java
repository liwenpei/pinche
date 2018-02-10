package com.gionee.pay.promotion.service.security;

import com.gionee.common.exception.BizException;
import com.gionee.common.vo.BaseVo;

/**
 * @author dingyw
 *
 * 2016年8月19日
 */
public interface SecurityFacade {
	/**
	 * 验证签名
	 * 
	 * @param vo
	 * @return
	 */
	public void verifySign(BaseVo vo,String sign) throws BizException;
	
	/**
	 * 生成签名
	 * 
	 * @param vo
	 * @return
	 */
	public String getSign(BaseVo vo) throws BizException;
	
	/**
	 * @param signContent
	 * @return
	 * @throws BizException
	 */
	public String getMd5(String signContent) throws BizException;
	
	/**
	 * @param signContent
	 * @param key
	 * @return
	 * @throws BizException
	 */
	public String getMd5(String signContent,String key) throws BizException;

}
