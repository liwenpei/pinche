/**
 * 
 */
package com.gionee.pay.promotion.core.service.impl.order;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.gionee.common.exception.BizException;
import com.gionee.common.exception.NotRollBackBizException;
import com.gionee.pay.promotion.core.service.order.OrderPayService;
import com.gionee.pay.promotion.core.vo.SynOrderListRspVo;
import com.gionee.pay.promotion.core.vo.SynOrderRspVo;
import com.gionee.pay.promotion.core.vo.models.PayPromotionCoreOrderTab;
import com.gionee.pay.promotion.core.vo.models.PayPromotionCoreTxnLogTab;

/**
 * @author liwenpei
 *
 * 2016年8月4日
 */
@Service
public class OrderPayServiceImpl implements OrderPayService {

	Logger log = LoggerFactory.getLogger(getClass());
	
	
	@Override
	public SynOrderListRspVo createPayOrders(PayPromotionCoreTxnLogTab txn , List<PayPromotionCoreOrderTab> orders) throws BizException,NotRollBackBizException{
		List<SynOrderRspVo> list = new ArrayList<SynOrderRspVo>();
		if(orders != null && orders.size() > 0){
			//先返回数据，然后延迟发送红包
			for(PayPromotionCoreOrderTab order : orders){
				list.add(getResponseInfo(order));
			}
		}
		
		return rntRspMsgVo(list);
	}
	
	/**
	 * 生成返回数据*/
	private SynOrderListRspVo rntRspMsgVo(List<SynOrderRspVo> list){
		
		SynOrderListRspVo body = new SynOrderListRspVo();
		if(list != null){
			body.setTotal(list.size() + "");
			body.setList(list);
		}
		
		return body;
	}
	
	/**
	 * 返回信息：body信息*/
	private SynOrderRspVo getResponseInfo(PayPromotionCoreOrderTab order){
		SynOrderRspVo synOrderRspVo = new SynOrderRspVo();
		//拼接活动描述
		String activityDesc = order.getActivity_desc();
		if(activityDesc != null){
			activityDesc = activityDesc.replace("activity_name", order.getActivity_name());
		}
		synOrderRspVo.setActivity_desc(activityDesc);
		synOrderRspVo.setAmount(order.getGift_trans_amt().toString()+"元");
		synOrderRspVo.setShare_statement(order.getShare_statement());
		synOrderRspVo.setShare_desc(order.getShare_desc());
		synOrderRspVo.setShare_pic_url(order.getShare_pic_url());
		synOrderRspVo.setShare_url(order.getShare_url());
		
		String sponsor = order.getSponsor();
		if(sponsor != null){
			sponsor = "您已获得"+sponsor+"赠送的红包";
		}
		synOrderRspVo.setSponsor_desc(sponsor);
		
		return synOrderRspVo;
	}
	
}
