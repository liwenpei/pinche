/**
 * 
 */
package com.gionee.pay.promotion.core.service.impl.order;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.SortedMap;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.gionee.common.exception.BizException;
import com.gionee.common.utils.AmigoHttpUtils;
import com.gionee.common.utils.CommonUtil;
import com.gionee.common.utils.xml.JaxbUtil;
import com.gionee.common.utils.xml.JaxbUtil.CollectionWrapper;
import com.gionee.pay.promotion.core.sao.OrderPaySao;
import com.gionee.pay.promotion.core.service.order.WxPromotionTransferService;
import com.gionee.pay.promotion.core.vo.WxPromotionTranserRspVo;
import com.gionee.pay.promotion.core.vo.models.PayPromotionCoreOrderTab;

import net.sf.json.JSONObject;

/**
 * @author liwenpei
 *
 * 2016年10月8日
 */
@Service
public class WxPromotionTransferServiceImpl implements WxPromotionTransferService {

	private Logger log = LoggerFactory.getLogger(getClass());
	private String amigo_send_red_pack_url;
	private String amigo_send_red_pack_key;
	private String amigo_wx_pkc12_password;
	private String amigo_wx_pkc12_path;
	
	
	private String send_red_pack_key;
	private String wx_pkc12_password;
	private String wx_pkc12_path;
	
	private String amigo_wx_app_id;
	
	@Autowired
	private OrderPaySao orderPaySao;
 
	/**
	 * 初始化支付订单*/
	public String initPayData(PayPromotionCoreOrderTab order) throws BizException {
		String postData = "";
		String mch_appid = this.amigo_wx_app_id;
		String mchid = CommonUtil.stringWithoutNull(order.getMerchant_id());
		String device_info = "";//暂时不需要
	    String nonce_str = CommonUtil.getUUID();
	    String sign = "";
	    String day = new SimpleDateFormat("yyyyMMdd").format(new Date());
		String tenNum = (Calendar.getInstance().getTimeInMillis() + "").substring(3);
	    String partner_trade_no = order.getMerchant_id() + day + tenNum;
	    String openid = CommonUtil.stringWithoutNull(order.getWechat_open_id());
	    String check_name = "NO_CHECK";
	    String re_user_name = CommonUtil.stringWithoutNull(order.getSponsor());
	    int amount = CommonUtil.bigDecimalToInt((order.getGift_trans_amt().multiply(new BigDecimal("100"))));//单位是分
	    String desc = CommonUtil.stringWithoutNull(order.getWish_desc());
	    String spbill_create_ip = CommonUtil.stringWithoutNull(order.getClient_ip());
	    
		// 微信api提供的参数
		SortedMap<String, Object> parameters = new TreeMap<String, Object>();
		parameters.put("mch_appid", mch_appid);
		parameters.put("mchid", mchid);
		parameters.put("device_info", device_info);
		parameters.put("nonce_str", nonce_str);
		parameters.put("partner_trade_no", partner_trade_no);
		parameters.put("openid", openid);
		parameters.put("check_name", check_name);
		parameters.put("re_user_name", re_user_name);
		parameters.put("amount", amount);
		parameters.put("desc", desc);
		parameters.put("spbill_create_ip", spbill_create_ip);
		// 地址是json格式，有多个存在
		JSONObject jsonObj = JSONObject.fromObject(amigo_wx_pkc12_password);
		// 如果没有密码,则使用初始密码
		wx_pkc12_password = jsonObj.getString(order.getMerchant_id());
		if (wx_pkc12_password == null) {
			wx_pkc12_password = order.getMerchant_id();
		}
		// 证书路径
		jsonObj = JSONObject.fromObject(amigo_wx_pkc12_path);
		wx_pkc12_path = jsonObj.getString(order.getMerchant_id());
		// 证书key
		jsonObj = JSONObject.fromObject(amigo_send_red_pack_key);
		send_red_pack_key = jsonObj.getString(order.getMerchant_id());
		if (send_red_pack_key == null || send_red_pack_key.isEmpty()) {
			throw new BizException("证书key为空");
		}
		String characterEncoding = "UTF-8";
		sign = AmigoHttpUtils.createSign(send_red_pack_key, characterEncoding, parameters);

		order.setNonce_str(nonce_str);
		order.setSign(sign);

		StringBuilder content = new StringBuilder();
		try {
			content = AmigoHttpUtils.joinKeyAndValue(parameters);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		postData = getPostData(content, sign);
		return postData;
	}
	

    
	
	@Override
	public WxPromotionTranserRspVo send(PayPromotionCoreOrderTab order) throws BizException {
		String postData = initPayData(order);
		String response = "<xml></xml>";
		try {
			log.info("发送钱包提交数据：" + postData);
			orderPaySao.initSendRedPack(amigo_send_red_pack_url, wx_pkc12_password, postData, wx_pkc12_path);
			response = orderPaySao.sendRedPack();

			log.info("发送钱包之后返回数据：" + response);
		} catch (Exception e) {
			log.info(e.getMessage(), e);
		}

		JaxbUtil resultBinder = new JaxbUtil(WxPromotionTranserRspVo.class, CollectionWrapper.class);
		WxPromotionTranserRspVo wxSendRedPackRspVo = resultBinder.fromXml(response);
		return wxSendRedPackRspVo;
	}

	
	private String getPostData(StringBuilder content, String sign) {
		content.insert(0, "<xml>");
		content.append("<sign>" + sign + "</sign></xml>");
		return content.toString();
	}
	

	public String getAmigo_send_red_pack_url() {
		return amigo_send_red_pack_url;
	}
	
	@Value("#{redirect_config['amigo_send_red_pack_url']}")
	public void setAmigo_send_red_pack_url(String amigo_send_red_pack_url) {
		this.amigo_send_red_pack_url = amigo_send_red_pack_url;
	}
	
	public String getAmigo_send_red_pack_key() {
		return amigo_send_red_pack_key;
	}
	
	@Value("#{wx_send_red_pack_config['amigo_send_red_pack_key']}")
	public void setAmigo_send_red_pack_key(String amigo_send_red_pack_key) {
		this.amigo_send_red_pack_key = amigo_send_red_pack_key;
	}

	public String getAmigo_wx_pkc12_password() {
		return amigo_wx_pkc12_password;
	}

	@Value("#{wx_send_red_pack_config['amigo_wx_pkc12_password']}")
	public void setAmigo_wx_pkc12_password(String amigo_wx_pkc12_password) {
		this.amigo_wx_pkc12_password = amigo_wx_pkc12_password;
	}
	
	public String getAmigo_wx_app_id() {
		return amigo_wx_app_id;
	}
	@Value("#{wx_send_red_pack_config['amigo_wx_app_id']}")
	public void setAmigo_wx_app_id(String amigo_wx_app_id) {
		this.amigo_wx_app_id = amigo_wx_app_id;
	}
	
	public String getAmigo_wx_pkc12_path() {
		return amigo_wx_pkc12_path;
	}

	@Value("#{wx_send_red_pack_config['amigo_wx_pkc12_path']}")
	public void setAmigo_wx_pkc12_path(String amigo_wx_pkc12_path) {
		this.amigo_wx_pkc12_path = amigo_wx_pkc12_path;
	}

 
	
	
}
