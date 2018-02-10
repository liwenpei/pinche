package com.gionee.pay.promotion.service.cache.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gionee.pay.promotion.core.vo.models.PayPromotionAnnouncementTab;
import com.gionee.pay.promotion.core.vo.models.PayPromotionCoreActivityTab;
import com.gionee.pay.promotion.dao.cache.CacheSao;
import com.gionee.pay.promotion.service.cache.redis.AnnouncementCacheService;
@Service
public class AnnouncementCacheServiceImpl implements AnnouncementCacheService{
	public final static String prefixKey = "PayPromotionAnnouncementTab";
	private Logger log = Logger.getLogger(this.getClass());
	/**
	 * 缓存接口
	 */
	@Autowired
	CacheSao cacheSao;
	
	@Override
	public void updateCache(String id, PayPromotionAnnouncementTab bean) {
		
		updateAnnouncementTabsWithFlag(id);
	}

	@Override
	public void delete(String id, PayPromotionAnnouncementTab bean) {

		updateAnnouncementTabsWithFlag(id);
	}

	@Override
	public void setAnnouncementTab(String id, PayPromotionAnnouncementTab bean) {
		String key = prefixKey + "_"+id;
		try{
			cacheSao.setObject(key, bean);
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage(), e);
		}
		
	}

	@Override
	public PayPromotionAnnouncementTab getAnnouncementTab( String clsName,String id) {
		String key = clsName + "_"+id;
		PayPromotionAnnouncementTab payPromotionAnnouncementTab = null;
		try{
			payPromotionAnnouncementTab = (PayPromotionAnnouncementTab)cacheSao.getObject(key); 
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage(), e);
		}
		return payPromotionAnnouncementTab;
	}

	@Override
	public List<PayPromotionAnnouncementTab> getAnnouncementTabs(String app_id) {
		String key = prefixKey+"_list_"+ app_id;
		List<PayPromotionAnnouncementTab> list = null;
		try{
			list = (List<PayPromotionAnnouncementTab>)cacheSao.getObject(key); 
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage(), e);
		}
		return list;
	}
	
	@Override
	public void setAnnouncementTabs(String app_id, List<PayPromotionAnnouncementTab> list) {
		if(list != null && !list.isEmpty()){
			String key = prefixKey + "_list_" + app_id;
			try{
				cacheSao.setObject(key, list); 
			}catch(Exception e){
				e.printStackTrace();
				log.error(e.getMessage(), e);
			}
		}
		
	}
	
	public void updateAnnouncementTabsWithFlag(String id){
		
	}

	
}
