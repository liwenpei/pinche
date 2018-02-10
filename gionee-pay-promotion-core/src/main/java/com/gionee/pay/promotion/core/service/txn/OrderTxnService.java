package com.gionee.pay.promotion.core.service.txn;

import com.gionee.common.exception.BizException;
import com.gionee.pay.promotion.core.vo.SynOrderVo;
import com.gionee.pay.promotion.core.vo.models.PayPromotionCoreActivityTab;
import com.gionee.pay.promotion.core.vo.models.PayPromotionCoreTxnLogTab;
import com.gionee.pay.promotion.core.vo.models.PayPromotionCoreWxRedPackWithActTab;

/**
 * @author: wuxing
 * @date: 2015年12月8日 下午2:03:43
 * 
 */
public interface OrderTxnService {
	
	/**初始化事务
	 * @param vo
	 * @return
	 */
	PayPromotionCoreTxnLogTab txn_initial(SynOrderVo synOrderVo);
	
	
	/**初始化活动事务
	 * @param vo
	 * @return
	 */
    PayPromotionCoreTxnLogTab txn_activity(PayPromotionCoreTxnLogTab txtTab,PayPromotionCoreActivityTab actTab);
    
    /**初始红包和活动事务
	 * @param vo
	 * @return
	 */
    PayPromotionCoreTxnLogTab initRedPackAndActivity(PayPromotionCoreTxnLogTab txtVo,PayPromotionCoreWxRedPackWithActTab map);
    
    /**初始订单事务
	 * @param vo
	 * @return
	 */
    PayPromotionCoreTxnLogTab initOrderInfo(PayPromotionCoreTxnLogTab txn,PayPromotionCoreWxRedPackWithActTab tab);
    
    /**
     * 插入事务数据库
     * **/
    int insertTxnLogTab(PayPromotionCoreTxnLogTab txn);
    
    int selectCountByOrderNo(String req_order_no);
    
    public void txn_successTxn(PayPromotionCoreTxnLogTab txn);
    
    public void txn_failTxn(PayPromotionCoreTxnLogTab txn, Exception e);
    
    public void txn_taskSuccessTxn(PayPromotionCoreTxnLogTab txn);
    
    public void txn_taskFailTxn(PayPromotionCoreTxnLogTab txn, Exception e);
    
    /**
	 * 根据流水号获取最新事务信息**/
	public PayPromotionCoreTxnLogTab queryLastTxn(String int_trade_no)throws BizException;
	 
}
