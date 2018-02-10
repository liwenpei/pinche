/**
 * 
 */
package com.gionee.pay.promotion.service;

import java.util.List;

import com.gionee.pay.promotion.core.vo.models.PayMerchant;

/**
 * @author liwenpei
 *
 * 2016年09月02日
 */
public interface QueryPayMerchantService {
	
    List<PayMerchant> getPayMerchantInfoByParams(String app_id );
}
