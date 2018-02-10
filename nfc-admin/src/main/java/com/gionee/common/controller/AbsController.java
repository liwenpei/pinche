package com.gionee.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.CharEncoding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gionee.common.exception.BizException;
import com.gionee.common.utils.CommonUtil;

/**
 * 父类abs controller
 * @author dingyw
 *
 * 2015年7月28日
 */
public class AbsController {
	Logger log = LoggerFactory.getLogger(getClass());
	/**
	 * 获取登录名
	 * @param httpSession
	 * @return
	 */
	protected String getUserId(HttpSession httpSession){
		
		return (String)httpSession.getAttribute("user_id");
	}
	
	public JSONObject getJSONObject(HttpServletRequest request)
			throws Exception {
		try {
			String json;
			json = IOUtils.toString(request.getInputStream(),
					CharEncoding.UTF_8);
		
			String client_ip=CommonUtil.getIpAddress(request);
			
			JSONObject result=JSONObject.fromObject(json);
			
			result.put("ip", client_ip);//记录用户ip地址
			
			return result;
		} catch (Exception e) {
			log.error(e.getMessage(),e); 
			throw new BizException("", "错误");
		}

	}

	
}
