package com.gionee.pay.promotion.service.impl.check;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.gionee.common.constant.CommonConstant;
import com.gionee.common.exception.BizException;
import com.gionee.common.msg.MsgReqHeaderVo;
import com.gionee.pay.promotion.core.vo.SynOrderVo;
import com.gionee.pay.promotion.service.synOrder.check.CommomServiceCheckFacade;

import net.sf.json.JSONObject;

/**
 * @author dingyw
 *
 * 2015年2月1日
 * 
 * 公共服务校验类
 */
@Service
public class CommomServiceCheckFacadeImpl implements CommomServiceCheckFacade{
	private String amigo_send_red_pack_key  ;
	
	@Override
	public void checkInput(SynOrderVo vo) throws BizException{
		JSONObject jsonObj = JSONObject.fromObject(amigo_send_red_pack_key);
		if(!jsonObj.has(vo.getMch_id())){
			//检查商户id
			throw new BizException(CommonConstant.RSP_CODE.FAILED.getValue(),"不支持当前商户Id，请检查");
		}
	}

	@Override
	public void commonCheck(MsgReqHeaderVo vo)throws BizException {
		// TODO Auto-generated method stub
	}
	
	public String getAmigo_send_red_pack_key() {
		return amigo_send_red_pack_key;
	}

	@Value("#{wx_send_red_pack_config['amigo_send_red_pack_key']}")
	public void setAmigo_send_red_pack_key(String amigo_send_red_pack_key) {
		this.amigo_send_red_pack_key = amigo_send_red_pack_key;
	}
	
 
}
