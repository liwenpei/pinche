package com.gionee.pay.promotion.service.cache.redis;

import java.util.List;

import com.gionee.pay.promotion.core.vo.models.PayMerchant;
import com.gionee.pay.promotion.core.vo.models.PayPromotionAnnouncementTab;

public interface AnnouncementCacheService {

	public void updateCache(String id,PayPromotionAnnouncementTab bean);
	
	public void delete(String id, PayPromotionAnnouncementTab bean);
	
	public void setAnnouncementTab(String id,PayPromotionAnnouncementTab bean);
	
	public PayPromotionAnnouncementTab getAnnouncementTab(String key,String id);
	
	public List<PayPromotionAnnouncementTab> getAnnouncementTabs(String app_id);
	
	public void setAnnouncementTabs(String app_id,List<PayPromotionAnnouncementTab> list);
	
}
