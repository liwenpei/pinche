package com.gionee.pay.promotion.service;

import java.util.List;

import com.gionee.common.exception.BizException;
import com.gionee.pay.promotion.core.vo.models.PayMerchant;

public interface QueryMerchantService {
	List<PayMerchant> getPayMerchantInfoByParams(String app_id ) throws BizException;
	String getPlatformInfo(String app_id);
}
