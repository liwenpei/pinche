package com.gionee.common.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.gionee.common.exception.BizException;

/**
 * @author dingyw
 *
 * 2015年7月3日
 */
public interface BaseController<V,U> {
	/**查询所有的列表
	 * @param vo
	 * @param model
	 * @return
	 * @throws BizException
	 */
	public String query(V vo,Map<String,Object> model)throws BizException;
	
	
	/**查询详细
	 * @param vo
	 * @param model
	 * @return
	 * @throws BizException
	 */
	public String view(HttpSession httpSession,V vo,Map<String,Object> model)throws BizException;
	
	/**跳去编辑页面
	 * @param vo
	 * @param model
	 * @return
	 * @throws BizException
	 */
	public String edit(HttpSession httpSession,V vo,Map<String,Object> model)throws BizException;
	
	/**
	 * 修改
	 * @param vo
	 * @param model
	 * @return
	 * @throws BizException
	 */
	public String save(HttpSession httpSession,U vo,Map<String,Object> model)throws BizException;
	
	
}
