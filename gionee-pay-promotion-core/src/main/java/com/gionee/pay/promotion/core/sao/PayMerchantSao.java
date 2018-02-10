package com.gionee.pay.promotion.core.sao;

import java.util.List;
import java.util.Map;

import com.gionee.pay.promotion.core.vo.models.PayMerchant;

public interface PayMerchantSao {
	List<PayMerchant> getPayMerchantInfo(Map<String,Object> params,String order_param);
}
