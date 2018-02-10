package com.gionee.pay.promotion.service.impl;


import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gionee.common.constant.CommonConstant;
import com.gionee.pay.promotion.core.dao.mapper.PayPromotionCoreActivityTabMapper;
import com.gionee.pay.promotion.core.service.txn.OrderTxnService;
import com.gionee.pay.promotion.core.vo.models.PayPromotionCoreActivityTab;
import com.gionee.pay.promotion.service.QueryPayMerchantService;
import com.gionee.pay.promotion.service.QueryPromotionActivityService;
import com.gionee.pay.promotion.service.cache.redis.ActivityCacheService;
import com.gionee.pay.promotion.service.synOrder.check.OrderServiceCheckFacade;

/**
 * @author liwenpei
 *
 * 2016年8月07日
 */
@Service
public class QueryPromotionActivityServiceImpl implements QueryPromotionActivityService{

	Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	PayPromotionCoreActivityTabMapper payPromotionCoreActivityTabMapper;
	@Autowired
	QueryPayMerchantService payMerchantAllInfoSao;
	@Autowired
	ActivityCacheService activityCacheService;
	@Autowired
	OrderServiceCheckFacade orderCheckFacade; 
	@Autowired
	OrderTxnService orderTxnService;  
	private List<PayPromotionCoreActivityTab> clearInvaliteActivity(List<PayPromotionCoreActivityTab> payPromotionCoreActivityTabs){
		if(payPromotionCoreActivityTabs != null && payPromotionCoreActivityTabs.size() > 0){
			for(int i = payPromotionCoreActivityTabs.size()-1;i >= 0; i--){
				Date nowDate = new Date();
				if(payPromotionCoreActivityTabs.get(i).getExpired_time() != null){
					if(nowDate.compareTo(payPromotionCoreActivityTabs.get(i).getExpired_time()) > 0){
						payPromotionCoreActivityTabs.remove(i);
						continue;
					}
				}
				
				if(!CommonConstant.IsValid.Start.getValue().equals(payPromotionCoreActivityTabs.get(i).getStatus())){
					payPromotionCoreActivityTabs.remove(i);
					continue;
				}
			}
		}
		return payPromotionCoreActivityTabs;
	}
	
	@Override
	public List<PayPromotionCoreActivityTab> getActivityInfoByAppId(String app_id){
		List<PayPromotionCoreActivityTab> payPromotionCoreActivityTabs = activityCacheService.getActivityTabs(app_id);
		payPromotionCoreActivityTabs = clearInvaliteActivity(payPromotionCoreActivityTabs);
		if(payPromotionCoreActivityTabs == null || payPromotionCoreActivityTabs.isEmpty()){
			PayPromotionCoreActivityTab payPromotionCoreActivityTab = new PayPromotionCoreActivityTab();
			payPromotionCoreActivityTab.setApp_id(app_id);
			payPromotionCoreActivityTab.setMin_status(CommonConstant.IsValid.Start.getValue());
			payPromotionCoreActivityTab.setMax_status(CommonConstant.IsValid.Start.getValue());
			payPromotionCoreActivityTabs = payPromotionCoreActivityTabMapper.selectValueByAllParams(payPromotionCoreActivityTab);
			
			activityCacheService.setActivityTabs(app_id, payPromotionCoreActivityTabs);
		}
		
		return payPromotionCoreActivityTabs;
	}
	@Override
	public List<PayPromotionCoreActivityTab> getActivityInfoByPlayFormType(String platform_type){
		PayPromotionCoreActivityTab payPromotionCoreActivityTab = new PayPromotionCoreActivityTab();
		payPromotionCoreActivityTab.setPlatform_type(platform_type);
		payPromotionCoreActivityTab.setMin_status(CommonConstant.IsValid.Start.getValue());
		payPromotionCoreActivityTab.setMax_status(CommonConstant.IsValid.Start.getValue());
		return payPromotionCoreActivityTabMapper.selectValueByAllParams(payPromotionCoreActivityTab);
	}
}
