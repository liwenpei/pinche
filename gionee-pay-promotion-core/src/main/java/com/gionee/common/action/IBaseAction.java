
package com.gionee.common.action;
import net.sf.json.JSONObject;

/**
 * @author dingyw
 *
 * 2015年1月14日
 */
public interface IBaseAction<T> {
	/**
	 * @param msgVo
	 * @return
	 * @throws Exception
	 * action的公共服务函数
	 */
	public T execute(T msgVo)throws Exception;
	
	/**
	 * 不用epay sdk时的框架(旧框架)
	 */
	public T getMsg(JSONObject json)throws Exception;
	
	

	
	
}
