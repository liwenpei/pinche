package com.gionee.pay.promotion.service.cache.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gionee.pay.promotion.core.vo.models.PayPromotionCoreActivityTab;
import com.gionee.pay.promotion.dao.cache.CacheSao;
import com.gionee.pay.promotion.service.cache.redis.ActivityCacheService;
@Service
public class ActivityCacheServicempl implements ActivityCacheService{
	public final static String prefixKey = "PayPromotionCoreActivityTab";
	Logger log = Logger.getLogger(this.getClass());
	/**
	 * 缓存接口
	 */
	@Autowired
	CacheSao cacheSao;

	@SuppressWarnings("unchecked")
	@Override
	public List<PayPromotionCoreActivityTab> getActivityTabs(String app_id) {
		String key = prefixKey+"_list_"+ app_id;
		List<PayPromotionCoreActivityTab> list = (List<PayPromotionCoreActivityTab>)cacheSao.getObject(key);
		return list;
	}

	@Override
	public void setActivityTabs(String app_id, List<PayPromotionCoreActivityTab> list) {
		if(list != null && !list.isEmpty()){
			String key = prefixKey + "_list_" + app_id;
			cacheSao.setObject(key, list);
		}
	}
	
	 

	
}
