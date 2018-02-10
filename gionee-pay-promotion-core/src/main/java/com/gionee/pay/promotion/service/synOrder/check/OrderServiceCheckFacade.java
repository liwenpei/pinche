package com.gionee.pay.promotion.service.synOrder.check;

import com.gionee.common.exception.BizException;
import com.gionee.pay.promotion.core.vo.SynOrderVo;
import com.gionee.pay.promotion.core.vo.models.PayPromotionCoreOrderTab;
import com.gionee.pay.promotion.core.vo.models.PayPromotionCoreTxnLogTab;

/**
 * @author dingyw
 *
 * 2016年1月7日
 */
public interface OrderServiceCheckFacade {
	/**校验订单
	 * @param SynOrderVo
	 *
	 */
	public void checkOrder(SynOrderVo vo) throws BizException;
	
	/**
	 * 校验准备发送红包**/
	public void checkPrepareWxSend(PayPromotionCoreTxnLogTab txn, PayPromotionCoreOrderTab order) throws BizException;

}
