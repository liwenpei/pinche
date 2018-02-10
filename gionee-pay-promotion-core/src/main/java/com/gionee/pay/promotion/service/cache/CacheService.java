package com.gionee.pay.promotion.service.cache;

import java.util.List;

import com.gionee.pay.promotion.core.vo.models.PayMerchant;

/**
 * 封装缓存接口
 * @author dingyw
 *
 * 2016年7月27日
 */
public interface CacheService {
	
	/**获取缓存数据
	 * @param key
	 * @return
	 */
	public String get(String key);
	
	/**设置缓存数据
	 * @param key
	 * @param val
	 */
	public void set(String key,String val);
	
	public List<PayMerchant> getPayMerchant(String id );
	public void setPayMerchant(String id, List<PayMerchant> bean);

}
