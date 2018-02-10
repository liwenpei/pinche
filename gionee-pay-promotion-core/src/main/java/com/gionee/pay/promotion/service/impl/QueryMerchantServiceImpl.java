/**
 * 
 */
package com.gionee.pay.promotion.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gionee.common.constant.CommonConstant;
import com.gionee.common.exception.BizException;
import com.gionee.pay.promotion.core.vo.models.PayMerchant;
import com.gionee.pay.promotion.service.QueryMerchantService;
import com.gionee.pay.promotion.service.QueryPayMerchantService;


/**
 * @author liwenpei
 *20160902
 */
@Service
public class QueryMerchantServiceImpl implements QueryMerchantService{
	Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	QueryPayMerchantService mchService;
	
	@Override
	public List<PayMerchant> getPayMerchantInfoByParams(String app_id) throws BizException {
		
		List<PayMerchant> payMerchants = mchService.getPayMerchantInfoByParams(app_id);
		return payMerchants;
	}
	
	@Override
	public String getPlatformInfo(String app_id) {
		// 获取appid对应的平台信息
		List<PayMerchant> payMerchants = null;
		try {
			payMerchants = this.getPayMerchantInfoByParams(app_id);
		} catch (BizException e) {
			log.info(e.getMessage(),e);
		}
		if (payMerchants != null && payMerchants.size() > 0) {
			return CommonConstant.PLATFORM_TYPE.getValueByDesc(payMerchants.get(0).getType());
		}

		return null;
	}
	 
}
