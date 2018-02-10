package com.gionee.pay.promotion.service.cache.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gionee.pay.promotion.core.vo.models.PayMerchant;
import com.gionee.pay.promotion.dao.cache.CacheSao;
import com.gionee.pay.promotion.service.cache.CacheService;

/**缓存服务
 * @author dingyw
 *
 * 2016年7月27日
 */
@Service
public class CacheServiceImpl implements CacheService{
	public final static String payMerchantPrefixKey = "PayMerchant";
	private Logger log = Logger.getLogger(this.getClass());
	/**
	 * 缓存接口
	 */
	@Autowired
	CacheSao cacheSao;

	@Override
	public String get(String key) {
		return cacheSao.get(key);
	}

	@Override
	public void set(String key, String val) {
		cacheSao.set(key, val);
	}

	@Override
	public List<PayMerchant> getPayMerchant( String id ) {
		String key = payMerchantPrefixKey  + "_list_"+id;
		List<PayMerchant> list = null;
		try{
			list = (List<PayMerchant>)cacheSao.getObject(key); 
		}catch(Exception e){
			log.error(e.getMessage(), e);
		}
		return list;
	}

	@Override
	public void setPayMerchant(String id, List<PayMerchant> list) {
		if(list != null && !list.isEmpty()){
			String key = payMerchantPrefixKey + "_list_"+id;
			try{
				cacheSao.setObject(key, list); 
			}catch(Exception e){
				log.error(e.getMessage(), e);
			}
		}
	}

}
