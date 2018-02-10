package com.gionee.pay.promotion.action;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gionee.common.action.AbsBaseAction;
import com.gionee.common.constant.CommonConstant;
import com.gionee.common.exception.BizException;
import com.gionee.common.msg.ReqMsgVo;
import com.gionee.common.msg.RspMsgVo;
import com.gionee.common.utils.CommonMsgUtils;
import com.gionee.common.vo.BaseMsgVo;
import com.gionee.pay.promotion.core.vo.QueryPromotionActivityReqVo;
import com.gionee.pay.promotion.core.vo.QueryPromotionActivityRspVo;
import com.gionee.pay.promotion.core.vo.models.PayMerchant;
import com.gionee.pay.promotion.core.vo.models.PayPromotionCoreActivityTab;
import com.gionee.pay.promotion.service.QueryPayMerchantService;
import com.gionee.pay.promotion.service.QueryPromotionActivityService;

import net.sf.json.JSONObject;

/**
 * 查询营销活动
 * @author 李文沛
 *
 * 2016年7月27日
 */
@Service("queryPromotionActivityAction")
public class QueryPromotionActivityAction extends AbsBaseAction<BaseMsgVo>{
	Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	QueryPromotionActivityService activityService ;
	
	@Autowired
	QueryPayMerchantService merchantService ;
	@Override
	public BaseMsgVo execute(BaseMsgVo msgVo) throws BizException {
		log.info("查询营销活动信息：QueryPromotionActivityAction-->" + msgVo);
		ReqMsgVo reqMsg = (ReqMsgVo) msgVo;// 获取vo
		QueryPromotionActivityReqVo vo = (QueryPromotionActivityReqVo) reqMsg.getBody();
		
		//获取活动信息
		List<PayPromotionCoreActivityTab> list = getActivatedActivityInfo(vo.getApp_id());
		
		//构造body信息
		QueryPromotionActivityRspVo body = convertRspBody(list);
		
		// 如果成功，返回成功报文
		RspMsgVo result = new RspMsgVo();// 无body返回
		result.setHeader(CommonMsgUtils.getHeader());
		result.setBody(body);
		log.info("result->" + result);
		return result;
	}
	
	/**构造返回信息*/
	private QueryPromotionActivityRspVo convertRspBody(List<PayPromotionCoreActivityTab> list){
		QueryPromotionActivityRspVo body = null;
		if(list != null && list.size() > 0){
			body = new QueryPromotionActivityRspVo();
			body.setMark(list.get(0).getMark());
			body.setPay_channel(list.get(0).getPay_channel());
		}
		
		return body;
	}
	
	/**
	 * 获取激活活动信息 获取次序 appid->type->all
	 * @throws BizException 
	 * **/
	private List<PayPromotionCoreActivityTab> getActivatedActivityInfo(String appId) throws BizException{
		List<PayPromotionCoreActivityTab> list = activityService.getActivityInfoByAppId(appId);		
		if(list != null && list.size() > 0){
			log.debug("根据appid获取到的数据信息为：" + list);
			return list;
		}
		
		List<PayMerchant> merchantList = merchantService.getPayMerchantInfoByParams(appId);
		if(merchantList != null && merchantList.size() > 0){
			list = activityService.getActivityInfoByPlayFormType(CommonConstant.PLATFORM_TYPE.getValueByDesc(merchantList.get(0).getType()));//
			if(list != null && list.size() > 0){
				log.info("根据type获取到的数据信息为：" + list);
				return list;
			}
		}
		
		
		list = activityService.getActivityInfoByPlayFormType(CommonConstant.PLATFORM_TYPE.ALL.getValue());
		if(list != null && list.size() > 0){
			log.info("根据All获取到的数据信息为：" + list);
			return list;
		}
		
		return null;
	}

	@Override
	public BaseMsgVo getMsg(JSONObject json) throws Exception {
		log.info("getVoFromJson:"+json);
		return this.getMsgVo(json, QueryPromotionActivityReqVo.class);
	}
}