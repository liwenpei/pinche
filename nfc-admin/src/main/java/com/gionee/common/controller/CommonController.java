package com.gionee.common.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.gionee.common.exception.BizException;

/**
 * @author dingyw
 *
 * 2015年7月3日
 */
public interface CommonController<V,U> extends BaseController<V, U>{

	
	/**跳去添加的页面
	 * @param vo
	 * @param model
	 * @return
	 * @throws BizException
	 */
	public String addView(HttpSession httpSession,V vo,Map<String,Object> model)throws BizException;

	
	/**
	 * 添加
	 * @param vo
	 * @param model
	 * @return
	 * @throws BizException
	 */
	public String add(HttpSession httpSession,U vo,Map<String,Object> model)throws BizException;
	
}
