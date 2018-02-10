package com.gionee.pay.promotion.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gionee.common.constant.CommonConstant;
import com.gionee.common.exception.BizException;
import com.gionee.pay.promotion.core.dao.mapper.PayPromotionAnnouncementTabMapper;
import com.gionee.pay.promotion.core.vo.models.PayPromotionAnnouncementTab;
import com.gionee.pay.promotion.service.QueryAnnouncementService;
import com.gionee.pay.promotion.service.cache.redis.AnnouncementCacheService;

/**
 * @author liwenpei
 *
 * 2016年7月27日
 */
@Service
public class QueryAnnouncementServiceImpl implements QueryAnnouncementService{
	Logger log = LoggerFactory.getLogger(getClass());
	
	/**
	 * 数据层*/
	@Autowired
	PayPromotionAnnouncementTabMapper payPromotionAnnouncementTabMapper;
	

	@Autowired
	AnnouncementCacheService announcementCacheService;
	
	private List<PayPromotionAnnouncementTab> clearInvaliteAnnouncement(List<PayPromotionAnnouncementTab> payPromotionAnnouncementTabs){
		if(payPromotionAnnouncementTabs != null && payPromotionAnnouncementTabs.size() > 0){
			for(int i = payPromotionAnnouncementTabs.size()-1;i >= 0; i--){
				Date nowDate = new Date();
				if(payPromotionAnnouncementTabs.get(i).getExpired_time() != null){
					if(nowDate.compareTo(payPromotionAnnouncementTabs.get(i).getExpired_time()) > 0){
						payPromotionAnnouncementTabs.remove(i);
						continue;
					}
				}
				
				if(CommonConstant.IsValid.False.getValue().equals(payPromotionAnnouncementTabs.get(i).getStatus())){
					payPromotionAnnouncementTabs.remove(i);
					continue;
				}
			}
		}
		return payPromotionAnnouncementTabs;
		}
	@Override
	public List<PayPromotionAnnouncementTab> getPromotionAnnouncementTabInfoByAppId(String app_id) throws BizException {
		List<PayPromotionAnnouncementTab> payPromotionAnnouncementTabs = announcementCacheService.getAnnouncementTabs(app_id);
		//清除失效或者无效的广告
		payPromotionAnnouncementTabs = clearInvaliteAnnouncement(payPromotionAnnouncementTabs);
		if(payPromotionAnnouncementTabs == null || payPromotionAnnouncementTabs.size() == 0){
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("app_id", app_id);
			params.put("status", CommonConstant.IsValid.True.getValue());	
			payPromotionAnnouncementTabs =  payPromotionAnnouncementTabMapper.selectValueByAllParams(params, null);
			announcementCacheService.setAnnouncementTabs( app_id, payPromotionAnnouncementTabs);
		}
		
		return payPromotionAnnouncementTabs;
	}
	@Override
	public List<PayPromotionAnnouncementTab> getPromotionAnnouncementTabInfoByPlatFormType(String platform_type)
			throws BizException {
		List<PayPromotionAnnouncementTab> payPromotionAnnouncementTabs = null;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("platform_type", platform_type);
		params.put("status", CommonConstant.IsValid.True.getValue());
		payPromotionAnnouncementTabs = payPromotionAnnouncementTabMapper.selectValueByAllParams(params, null);
		return payPromotionAnnouncementTabs;
	}
	
}
