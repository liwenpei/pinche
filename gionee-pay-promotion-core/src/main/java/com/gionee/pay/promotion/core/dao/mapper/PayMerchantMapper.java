package com.gionee.pay.promotion.core.dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.gionee.common.mapper.IBaseMapper;
import com.gionee.pay.promotion.core.vo.models.PayMerchant;

public interface PayMerchantMapper extends IBaseMapper<PayMerchant>{
    int deleteByPrimaryKey(String merchantID);

    int insert(PayMerchant record);

    int insertSelective(PayMerchant record);

    PayMerchant selectByPrimaryKey(String merchantID);

    int updateByPrimaryKeySelective(PayMerchant record);

    int updateByPrimaryKeyWithBLOBs(PayMerchant record);

    int updateByPrimaryKey(PayMerchant record);
    
    List<PayMerchant> selectAllListByParams(@Param(value="params") Map<String,Object> params,
			   @Param(value="order_param") String order_param );
}