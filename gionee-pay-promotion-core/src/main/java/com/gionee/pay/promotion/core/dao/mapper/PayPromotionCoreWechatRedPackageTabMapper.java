package com.gionee.pay.promotion.core.dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.gionee.pay.promotion.core.vo.models.PayPromotionCoreWechatRedPackageTab;
import com.gionee.pay.promotion.core.vo.models.PayPromotionCoreWechatRedPackageTabKey;
import com.gionee.pay.promotion.core.vo.models.PayPromotionCoreWxRedPackWithActTab;

public interface PayPromotionCoreWechatRedPackageTabMapper {
    int deleteByPrimaryKey(PayPromotionCoreWechatRedPackageTabKey key);

    int insert(PayPromotionCoreWechatRedPackageTab record);

    int insertSelective(PayPromotionCoreWechatRedPackageTab record);

    PayPromotionCoreWechatRedPackageTab selectByPrimaryKey(PayPromotionCoreWechatRedPackageTabKey key);

    int updateByPrimaryKeySelectiveWithStatus(PayPromotionCoreWechatRedPackageTab params);

    int updateByPrimaryKey(PayPromotionCoreWechatRedPackageTab record);
    
    List<PayPromotionCoreWechatRedPackageTab> selectByAllParams(PayPromotionCoreWechatRedPackageTab record );
    
    int selectGiftedCount(PayPromotionCoreWechatRedPackageTab record);
    
    /**
	 * 获取符合条件的红包和活动信息
	 * **/
	List<PayPromotionCoreWxRedPackWithActTab> selectActAndPackListByParams(@Param(value = "params") Map<String, Object> params);
}