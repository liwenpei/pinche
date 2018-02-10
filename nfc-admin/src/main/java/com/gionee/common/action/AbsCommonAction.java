package com.gionee.common.action;

import java.util.List;

import com.gionee.common.exception.BizException;

public interface AbsCommonAction<V,U> {
	
	/**查询所有列表
	 * @param vo
	 * @return
	 * @throws BizException
	 */
	public List<U> query(V vo) throws BizException;
	
	/**
	 * 根据id进行查询
	 * @param vo
	 * @return
	 * @throws BizException
	 */
	public U queryById(V vo)throws BizException;
	
	
	/**
	 * 更新
	 * @param vo
	 * @return
	 * @throws BizException
	 */
	public void update(U vo)throws BizException;
	
	/**
	 * 插入
	 * @param vo
	 * @return
	 * @throws BizException
	 */
	public void add(U vo)throws BizException;

}
