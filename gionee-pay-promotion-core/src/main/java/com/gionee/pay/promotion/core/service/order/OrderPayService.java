/**
 * 
 */
package com.gionee.pay.promotion.core.service.order;

import java.util.List;

import com.gionee.common.exception.BizException;
import com.gionee.common.exception.NotRollBackBizException;
import com.gionee.pay.promotion.core.vo.SynOrderListRspVo;
import com.gionee.pay.promotion.core.vo.models.PayPromotionCoreOrderTab;
import com.gionee.pay.promotion.core.vo.models.PayPromotionCoreTxnLogTab;

/**
 * @author liwenpei
 *
 * 2016年7月8日
 */
public interface OrderPayService {
    /**
     *支付订单 **/
    public SynOrderListRspVo createPayOrders(PayPromotionCoreTxnLogTab txn , List<PayPromotionCoreOrderTab> orders) throws BizException,NotRollBackBizException;
}
