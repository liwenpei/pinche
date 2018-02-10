package com.gionee.pay.promotion.core.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gionee.pay.promotion.core.vo.models.PayPromotionCoreActivityTab;

public interface PayPromotionCoreActivityTabMapper {
    int deleteByPrimaryKey(String activity_no);

    int insert(PayPromotionCoreActivityTab record);

    int insertSelective(PayPromotionCoreActivityTab record);

    PayPromotionCoreActivityTab selectByPrimaryKey(String activity_no);

    int updateByPrimaryKeySelective(PayPromotionCoreActivityTab record);

    int updateByPrimaryKey(PayPromotionCoreActivityTab record);
    
    List<PayPromotionCoreActivityTab> selectValueByAllParams(PayPromotionCoreActivityTab payPromotionCoreActivityTab );
    
}