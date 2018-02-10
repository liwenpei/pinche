package com.gionee.pay.promotion.service;

import java.util.List;

import com.gionee.pay.promotion.core.vo.models.PayPromotionCoreTxnLogTab;
import com.gionee.pay.promotion.core.vo.models.PayPromotionCoreWxRedPackWithActTab;

public interface PromotionCoreWxRedPackService {

	int getGiftedCount(String activity_no,String third_usr_id);
	
	List<PayPromotionCoreWxRedPackWithActTab> getActAndPactInfo(PayPromotionCoreTxnLogTab txn);
	
	int updateRedPack(PayPromotionCoreTxnLogTab txn);
}
