package com.gionee.pay.promotion.service;

import java.util.List;

import com.gionee.common.exception.BizException;
import com.gionee.pay.promotion.core.vo.models.PayPromotionAnnouncementTab;

/**
 * @author liwenpei
 *
 * 2016年7月27日
 */
public interface QueryAnnouncementService {
	/**
	 * 获取公告信息
	 * **/
	public List<PayPromotionAnnouncementTab> getPromotionAnnouncementTabInfoByAppId(String app_id) throws BizException ;
	
	public List<PayPromotionAnnouncementTab> getPromotionAnnouncementTabInfoByPlatFormType(String platform_type)throws BizException ;
}
