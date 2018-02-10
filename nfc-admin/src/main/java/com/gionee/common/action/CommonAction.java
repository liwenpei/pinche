package com.gionee.common.action;

import com.gionee.common.exception.BizException;

public interface CommonAction<V,U> extends AbsCommonAction<V, U> {
	
	/**
	 * 添加
	 * @param vo
	 * @return
	 * @throws BizException
	 */
	public void add(U vo)throws BizException;
	
	/**添加的view
	 * @param vo
	 * @return
	 * @throws BizException
	 */
	public U addView(V vo)throws BizException;
	


}
