package com.gionee.pay.promotion.core.service.order;

import java.util.List;

import com.gionee.common.exception.BizException;
import com.gionee.common.exception.NotRollBackBizException;
import com.gionee.pay.promotion.core.vo.models.PayPromotionCoreOrderTab;
import com.gionee.pay.promotion.core.vo.models.PayPromotionCoreTxnLogTab;

/**
 * @author: wuxing
 * @date: 2015年11月6日 上午10:37:05
 * 
 */
public interface OrderService {
	/**查询订单根据商户订单号查询
	 * @param order_no
	 * @return
	 * @throws BizException
	 */
	public int queryCountByReqOrderNo(String req_order_no) throws BizException;
	
	
	/**
	 * 初始化订单*/
	public List<PayPromotionCoreOrderTab> txn_initOrders(PayPromotionCoreTxnLogTab txn) throws BizException,NotRollBackBizException;
	
	/**
	 * 创建订单*/
	public void createOrders(List<PayPromotionCoreOrderTab> orders) throws BizException,NotRollBackBizException;
	
	/**
	 * 修改订单**/
	public int updateOrderTab(PayPromotionCoreOrderTab order) throws BizException,NotRollBackBizException;
	
	/**
	 * 获取订单信息**/
	public List<PayPromotionCoreOrderTab> queryPrepareOrders()throws BizException;
}
