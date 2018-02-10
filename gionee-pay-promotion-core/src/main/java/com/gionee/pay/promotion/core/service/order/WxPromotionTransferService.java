/**
 * 
 */
package com.gionee.pay.promotion.core.service.order;

import com.gionee.common.exception.BizException;
import com.gionee.pay.promotion.core.vo.WxPromotionTranserRspVo;
import com.gionee.pay.promotion.core.vo.models.PayPromotionCoreOrderTab;

/**
 * @author liwenpei
 * 微信赠送红包
 * 2016年10月8日
 */
public interface WxPromotionTransferService {
    /**
     *支付订单 **/
    public WxPromotionTranserRspVo send(PayPromotionCoreOrderTab order) throws BizException;
}
