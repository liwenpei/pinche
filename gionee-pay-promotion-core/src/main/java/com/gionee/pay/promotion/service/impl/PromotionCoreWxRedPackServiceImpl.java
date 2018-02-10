package com.gionee.pay.promotion.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gionee.common.constant.CommonConstant;
import com.gionee.common.utils.CommonUtil;
import com.gionee.pay.promotion.core.dao.mapper.PayPromotionCoreWechatRedPackageTabMapper;
import com.gionee.pay.promotion.core.vo.models.PayPromotionCoreTxnLogTab;
import com.gionee.pay.promotion.core.vo.models.PayPromotionCoreWechatRedPackageTab;
import com.gionee.pay.promotion.core.vo.models.PayPromotionCoreWxRedPackWithActTab;
import com.gionee.pay.promotion.service.PromotionCoreWxRedPackService;
/**
 * @author liwenpei
 *
 * 2016年7月27日
 */
@Service
public class PromotionCoreWxRedPackServiceImpl implements PromotionCoreWxRedPackService{
	
	@Autowired
	PayPromotionCoreWechatRedPackageTabMapper wxPackMapper;
	
	private int updateWechatRedPackageTab(PayPromotionCoreWechatRedPackageTab redPackTab){
		redPackTab.setLast_upd_time(new Date());
		return wxPackMapper.updateByPrimaryKeySelectiveWithStatus(redPackTab);
	}
	
	/**
	 * 获取已经僧送的红包个数**/
	@Override
	public int getGiftedCount(String activity_no,String third_usr_id) {
		PayPromotionCoreWechatRedPackageTab wxTab = new PayPromotionCoreWechatRedPackageTab();
		wxTab.setStatus(CommonConstant.RED_PACK_STATUS.SUCCESS.getValue());//已经领过的
		wxTab.setActivity_no(activity_no);//当前活动
		wxTab.setWechat_open_id(third_usr_id);//微信第三方用户id
		return wxPackMapper.selectGiftedCount(wxTab);
	}
	
	@Override
	public List<PayPromotionCoreWxRedPackWithActTab> getActAndPactInfo(PayPromotionCoreTxnLogTab txn) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("trans_type", txn.getTrans_type());
		params.put("app_id", txn.getApp_id());
		params.put("req_platform_type", txn.getReq_platform_type());
		params.put("amount", txn.getAmount());
		params.put("wechat_open_id", txn.getWechat_open_id());
		return wxPackMapper.selectActAndPackListByParams(params);
	}
	
	@Override
	public int updateRedPack(PayPromotionCoreTxnLogTab txn){
		PayPromotionCoreWechatRedPackageTab redPackTab = new PayPromotionCoreWechatRedPackageTab();
		if(CommonConstant.RED_PACK_STATUS.PREPARE.getValue().equals(txn.getPack_status())){
			redPackTab.setStatus(txn.getPack_status());//设置成准备领取状态
			redPackTab.setOld_statues(CommonConstant.RED_PACK_STATUS.INIT.getValue());
			
			redPackTab.setUser_id(txn.getUser_id());
			redPackTab.setWechat_open_id(txn.getWechat_open_id());
			redPackTab.setReq_order_no(txn.getOrder_no());
			redPackTab.setInt_order_no(txn.getInt_order_no());
			redPackTab.setInt_trade_no(txn.getInt_trade_no());//给红包添加流水
			redPackTab.setInt_txn_no(txn.getInt_txn_no());
			redPackTab.setReceived_time(new Date());
			redPackTab.setActivity_no(txn.getActivity_no());
			redPackTab.setPackage_seq_id(CommonUtil.stringToInt(txn.getPackage_seq_id()));
			return updateWechatRedPackageTab(redPackTab);
		}else if(CommonConstant.RED_PACK_STATUS.FAIL.getValue().equals(txn.getPack_status())
				||CommonConstant.RED_PACK_STATUS.SUCCESS.getValue().equals(txn.getPack_status())){
			
			redPackTab.setStatus(txn.getPack_status());
        	//记录红包
			redPackTab.setReceived_time(new Date());
			redPackTab.setOld_statues(null);
			redPackTab.setActivity_no(txn.getActivity_no());
			redPackTab.setPackage_seq_id(CommonUtil.stringToInt(txn.getPackage_seq_id()));
			return updateWechatRedPackageTab(redPackTab);
		}
		
		return 0;
	}
	
	
}
