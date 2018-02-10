package com.gionee.common.sao;
import com.gionee.common.exception.BizException;
/**
 * @author dingyw
 *
 * 2015年12月7日
 */
public interface BaseJmsSao {
	
	/**
	 *记录jms发送 
	 */
	public void sendMsg(final String msg) throws BizException;

}
