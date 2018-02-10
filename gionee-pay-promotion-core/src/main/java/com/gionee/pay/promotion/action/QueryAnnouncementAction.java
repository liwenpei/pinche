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
import com.gionee.pay.promotion.core.vo.QueryAnnouncementVo;
import com.gionee.pay.promotion.core.vo.models.PayMerchant;
import com.gionee.pay.promotion.core.vo.models.PayPromotionAnnouncementTab;
import com.gionee.pay.promotion.service.QueryAnnouncementService;
import com.gionee.pay.promotion.service.QueryPayMerchantService;
import com.gionee.pay.promotion.service.cache.CacheService;
import com.gionee.pay.promotion.service.cache.redis.AnnouncementCacheService;

import net.sf.json.JSONObject;

/**查询公告
 * @author dingyw
 *
 * 2016年7月27日
 */
@Service("queryAnnouncementAction")
public class QueryAnnouncementAction extends AbsBaseAction<BaseMsgVo>{

	Logger log = LoggerFactory.getLogger(getClass());
	
	
	/**
	 * 缓存服务层
	 */
	@Autowired
	AnnouncementCacheService announcementCacheService;
	
	/**
	 * 缓存服务层
	 */
	@Autowired
	CacheService cacheService;
	
	@Autowired
	QueryAnnouncementService queryAnnouncementService;
	
	@Autowired
	QueryPayMerchantService payMerchantAllInfoService; 
	
	@Override
	public BaseMsgVo execute(BaseMsgVo msgVo) throws BizException {
		log.info("查询公告：QueryAnnouncementAction-->" + msgVo);
		ReqMsgVo reqMsg = (ReqMsgVo) msgVo;// 获取vo
		QueryAnnouncementVo vo = (QueryAnnouncementVo) reqMsg.getBody();

		//获取公告信息
		List<PayPromotionAnnouncementTab> annos = getAnnouncementInfo(vo.getApp_id());
		
		//构造body信息
		QueryAnnouncementVo body = convertRspBody(annos);

		// 如果成功，返回成功报文
		RspMsgVo result = new RspMsgVo();// 无body返回
		result.setHeader(CommonMsgUtils.getHeader());
		result.setBody(body);
		log.info("result->" + result);
		return result;
	}
	
	/**构造返回信息*/
	private QueryAnnouncementVo convertRspBody(List<PayPromotionAnnouncementTab> annos){
		QueryAnnouncementVo body = null;
		if(annos != null && annos.size() > 0){
			body = new QueryAnnouncementVo();
			body.setAnnounce_id(annos.get(0).getAnnounce_id()+"");
			body.setAnnounce_name(annos.get(0).getAnnounce_name());
			body.setApp_id(annos.get(0).getApp_id());
			body.setDialog_content(annos.get(0).getAnnounce_content());
			body.setDialog_pic_url(annos.get(0).getPic_url());
			body.setDialog_title(annos.get(0).getAnnounce_name());
			body.setFloating_window_title(annos.get(0).getSlogan());
		}
		
		return body;
	}
	
	/**
	 * 获取公告信息
	 * @throws BizException **/
	private List<PayPromotionAnnouncementTab> getAnnouncementInfo(String app_id) throws BizException{
		List<PayPromotionAnnouncementTab> anno = queryAnnouncementService.getPromotionAnnouncementTabInfoByAppId(app_id);
		if(anno != null && anno.size() > 0){
			log.debug("根据appid获取到的数据信息为：" + anno);
			return anno;
		}
		
		List<PayMerchant> payMerchants = payMerchantAllInfoService.getPayMerchantInfoByParams(app_id);
		if(payMerchants != null && !payMerchants.isEmpty()){
			// 有单机版或网络版公告
			if (CommonConstant.PLATFORM_TYPE.ALONE.getDesc().equals(payMerchants.get(0).getType())
					|| CommonConstant.PLATFORM_TYPE.ONLINE.getDesc().equals(payMerchants.get(0).getType())) {
				anno = queryAnnouncementService.getPromotionAnnouncementTabInfoByPlatFormType(
						CommonConstant.PLATFORM_TYPE.getValueByDesc(payMerchants.get(0).getType()));
			}
			
			if(anno != null && anno.size() > 0){
				log.debug("根据type获取到的数据信息为：" + anno);
				return anno;
			}
		}

		anno = queryAnnouncementService.getPromotionAnnouncementTabInfoByPlatFormType(CommonConstant.PLATFORM_TYPE.ALL.getValue());
		log.debug("根据ALL获取到的数据信息为：" + anno);
		
		return anno;
	}

	@Override
	public BaseMsgVo getMsg(JSONObject json) throws Exception {
		log.info("getVoFromJson:"+json);
		return this.getMsgVo(json, QueryAnnouncementVo.class);
	}

}
