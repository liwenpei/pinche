package com.gionee.pay.promotion.service;

import java.util.List;

import com.gionee.common.exception.BizException;
import com.gionee.pay.promotion.core.vo.models.PayPromotionCoreActivityTab;

/**
 * @author liwenpei
 *
 * 2016年8月07日
 */
public interface QueryPromotionActivityService {
	/**
	 *  查询营销活动信息
	 * **/
	public List<PayPromotionCoreActivityTab> getActivityInfoByAppId(String vo)throws BizException;
	
	public List<PayPromotionCoreActivityTab> getActivityInfoByPlayFormType(String platform_type)throws BizException;
	
}
