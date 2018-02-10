package com.gionee.pay.promotion.core.dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.gionee.pay.promotion.core.vo.models.PayPromotionAnnouncementTab;

public interface PayPromotionAnnouncementTabMapper {
    int deleteByPrimaryKey(String announce_id);

    int insert(PayPromotionAnnouncementTab record);

    int insertSelective(PayPromotionAnnouncementTab record);

    PayPromotionAnnouncementTab selectByPrimaryKey(String announce_id);

    int updateByPrimaryKeySelective(PayPromotionAnnouncementTab record);

    int updateByPrimaryKey(PayPromotionAnnouncementTab record);
    
    List<PayPromotionAnnouncementTab> selectByAllParams(@Param(value="params") Map<String,Object> params,
			   @Param(value="order_param") String order_param );
    
    
    List<PayPromotionAnnouncementTab> selectValueByAllParams(@Param(value="params") Map<String,Object> params,
			   @Param(value="order_param") String order_param );
    
}