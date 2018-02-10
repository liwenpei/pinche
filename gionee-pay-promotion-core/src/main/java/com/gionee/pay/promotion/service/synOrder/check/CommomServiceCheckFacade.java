package com.gionee.pay.promotion.service.synOrder.check;

import com.gionee.common.exception.BizException;
import com.gionee.common.msg.MsgReqHeaderVo;
import com.gionee.pay.promotion.core.vo.SynOrderVo;

/**
 * @author liwenpei
 *
 * 2016年09月02日
 * 
 * 公共服务校验类
 */
public interface CommomServiceCheckFacade {
	/**公共校验,不包括校验token
	 * @param vo
	 * @throws BizException
	 */
	public void commonCheck(MsgReqHeaderVo vo) throws BizException;
	
	/**
	 * @param vo
	 * @throws BizException
	 */
	public void checkInput(SynOrderVo vo)throws BizException;
	
}
