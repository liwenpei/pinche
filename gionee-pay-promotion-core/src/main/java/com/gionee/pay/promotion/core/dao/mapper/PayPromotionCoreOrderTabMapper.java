package com.gionee.pay.promotion.core.dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.gionee.common.mapper.IBaseMapper;
import com.gionee.pay.promotion.core.vo.models.PayPromotionCoreOrderTab;

public interface PayPromotionCoreOrderTabMapper extends IBaseMapper<PayPromotionCoreOrderTab>{
    
    int selectRecordNum(PayPromotionCoreOrderTab record);
    
    List<PayPromotionCoreOrderTab> selectAllListByParams(@Param(value="params") Map<String,Object> params,
			   @Param(value="group_by_param") String group_by_param );
}