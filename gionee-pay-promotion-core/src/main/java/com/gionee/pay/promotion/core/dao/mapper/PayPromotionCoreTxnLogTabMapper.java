package com.gionee.pay.promotion.core.dao.mapper;

import com.gionee.common.mapper.IBaseMapper;
import com.gionee.pay.promotion.core.vo.models.PayPromotionCoreTxnLogTab;

public interface PayPromotionCoreTxnLogTabMapper extends IBaseMapper<PayPromotionCoreTxnLogTab>{
    int selectCountByOrderNo(String req_order_no);
    PayPromotionCoreTxnLogTab selectLastTxnByOrderNo(String int_order_no);
}
