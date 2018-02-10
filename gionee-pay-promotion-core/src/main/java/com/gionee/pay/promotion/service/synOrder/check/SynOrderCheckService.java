package com.gionee.pay.promotion.service.synOrder.check;

import com.gionee.common.exception.BizException;
import com.gionee.common.msg.ReqMsgVo;

/**
 * @author dingyw
 *
 * 2016年8月19日
 */
public interface SynOrderCheckService {
	
	/**
	 * @throws BizException
	 */
	public void checkSign(ReqMsgVo reqMsg) throws BizException;

}
