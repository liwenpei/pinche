package com.gionee.pay.promotion.service.cache.redis;

import java.util.List;

import com.gionee.pay.promotion.core.vo.models.PayPromotionCoreActivityTab;

public interface ActivityCacheService {
	public List<PayPromotionCoreActivityTab> getActivityTabs(String app_id);
	
	public void setActivityTabs(String app_id,List<PayPromotionCoreActivityTab> list);
}
