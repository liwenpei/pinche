/**
 * 
 */
package com.gionee.pay.promotion.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gionee.common.multidataSource.DataSourceContextHolder;
import com.gionee.common.multidataSource.DataSourceInstances;
import com.gionee.pay.promotion.core.sao.PayMerchantSao;
import com.gionee.pay.promotion.core.vo.models.PayMerchant;
import com.gionee.pay.promotion.service.QueryPayMerchantService;
import com.gionee.pay.promotion.service.cache.CacheService;

/**
 * @author liwenpei
 *
 *         2016年09月02日
 */
@Service
public class QueryPayMerchantServiceImpl implements QueryPayMerchantService {

	@Autowired
	PayMerchantSao payMchSao;
	
	@Autowired
	CacheService cacheService;
	@Override
	public List<PayMerchant> getPayMerchantInfoByParams(String app_id) {
		List<PayMerchant> payMerchants = cacheService.getPayMerchant( app_id);
		if (payMerchants == null || payMerchants.isEmpty()) {
			// 缓存上没有平台信息，从数据查询
			// 没有生效的公告，判断app_id属于单机版或网游版，然后根据单机版或网游版查询是否有活动公告，切换数据库
			Map<String, Object> params = new HashMap<String,Object>();
			params.put("merchantID", app_id);
			
			String order_param=null;
			
			DataSourceContextHolder.setDataSourceType(DataSourceInstances.DS_PAY);//切换到支付数据库
			payMerchants = payMchSao.getPayMerchantInfo(params, order_param);	
			DataSourceContextHolder.setDataSourceType(DataSourceInstances.DS_USER);//切换回当前数据库
			
			cacheService.setPayMerchant(app_id, payMerchants);
		}
		return payMerchants;
	}
	 
}
