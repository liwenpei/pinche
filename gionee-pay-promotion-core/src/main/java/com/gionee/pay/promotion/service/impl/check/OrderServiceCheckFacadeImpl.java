package com.gionee.pay.promotion.service.impl.check;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gionee.common.constant.CommonConstant;
import com.gionee.common.exception.BizException;
import com.gionee.pay.promotion.core.service.order.OrderService;
import com.gionee.pay.promotion.core.vo.SynOrderVo;
import com.gionee.pay.promotion.core.vo.models.PayPromotionCoreOrderTab;
import com.gionee.pay.promotion.core.vo.models.PayPromotionCoreTxnLogTab;
import com.gionee.pay.promotion.service.PromotionCoreWxRedPackService;
import com.gionee.pay.promotion.service.synOrder.check.OrderServiceCheckFacade;

/**
 * @author liwenpei
 *
 * 2016年09月02日
 */
@Service
public class  OrderServiceCheckFacadeImpl implements OrderServiceCheckFacade {
	Logger log = LoggerFactory.getLogger(getClass());
	/**
	 * 订单服务层
	 */
	@Autowired
	OrderService orderService;
	
	/**
	 * 红包服务层**/
	@Autowired
	PromotionCoreWxRedPackService redRackService;
	
	@Override
	public void checkOrder(SynOrderVo vo) throws BizException {
		if (null == vo) {
			throw new BizException("请求参数异常");
		}
		
		if(orderService.queryCountByReqOrderNo(vo.getOrder_no()) > 0){
			//已经在事务存在，则过滤该请求
			throw new BizException(CommonConstant.RSP_CODE.FAILED.getValue(),"重复订单");
		}
	}


	@Override
	public void checkPrepareWxSend(PayPromotionCoreTxnLogTab txn, PayPromotionCoreOrderTab order) throws BizException  {
		if(!CommonConstant.ORDER_STATUS.PREPARE.getValue().equals(order.getStatus())){
			//没有进入准备状态的自动过滤
			throw new BizException("订单不是准备状态");
		}
		
		if(!CommonConstant.PAY_CHANNEL.WECHATPAY.getValue().equals(order.getPay_channel())){
			throw new BizException("不是微信支付");
		}
		
		if(!CommonConstant.RED_PACK_STATUS.PREPARE.getValue().equals(txn.getPack_status())){
			throw new BizException("红包不是准备状态");
		}
		
	}
	
}
