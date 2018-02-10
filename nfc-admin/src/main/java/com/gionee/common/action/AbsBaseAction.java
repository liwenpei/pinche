package com.gionee.common.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.gionee.common.msg.MsgReqHeaderVo;
import com.gionee.common.msg.ReqMsgVo;
import com.gionee.common.utils.JsonUtils;
import com.gionee.common.utils.TransIdSerial;
import com.gionee.common.vo.BaseMsgVo;
import com.gionee.epay.client.EpaySDKRcv;

/**
 * @author dingyw
 *
 *         2017年6月27日
 */
public abstract class AbsBaseAction<T> implements IBaseAction<T> {
	Logger log = LoggerFactory.getLogger(getClass());


	public BaseMsgVo doAction(JSONObject json) throws Exception { // 由子类覆盖
		return null;
	}

	@Override
	public T getMsg(JSONObject json) throws Exception {// 由子类覆盖
		return null;
	}

	/**
	 * 子类覆盖该类，实现返回报文是否需要签名
	 * 
	 * @return
	 */
	public boolean is_need_sign() {
		return false;
	}

	/**
	 * 子类覆盖该类，实现返回报文是否需要加密
	 * 
	 * @return
	 */
	public boolean is_need_encry() {
		return false;
	}

	public T getMsg(JSONObject json, Class className) throws Exception {
		@SuppressWarnings("unchecked")
		T vo = (T) JSONObject.toBean(json, className);
		return vo;
	}
	public T getFastJsonMsg(String json, Class className) throws Exception {
		@SuppressWarnings("unchecked")
		T vo = (T) JsonUtils.readJson2Object(json, className);
		return vo;
	}


	public ReqMsgVo getMsgVo(JSONObject json, Map<String, Class> classMap, Class className) throws Exception {
		ReqMsgVo vo = new ReqMsgVo();
		// 先获取报文体
		if (!StringUtils.isEmpty(json.get("body"))) {
			String bodyStr = json.get("body").toString(); // 先转为String，再统一转json(兼容body格式是JSONObject或字符串)

			JSONObject bodyJson = JSONObject.fromObject(bodyStr);

			vo.setBody(this.getMsg(bodyJson, classMap, className));
		} else {

			T body = (T) className.newInstance();
			vo.setBody(body);
		}
		JSONObject temp = JSONObject.fromObject(json);
		temp.remove("body");// 需要去掉，不然会报错
		// 获取报文头
		MsgReqHeaderVo header = (MsgReqHeaderVo) this.getMsg(temp, MsgReqHeaderVo.class);
		// 强制生成req_trans_id,用来区分不同交易
		header.setReq_trans_id(TransIdSerial.genSeqId("121"));// 121开头，随机
		vo.setHeader(header);

		return vo;
	}

	public ReqMsgVo getMsgVo(JSONObject json, String itemName, Class className, Class itemClassName)
			throws Exception {
		ReqMsgVo vo = new ReqMsgVo();
		// 先获取报文体
		if (!StringUtils.isEmpty(json.get("body"))) {
			String bodyStr = json.get("body").toString(); // 先转为String，再统一转json(兼容body格式是JSONObject或字符串)

			JSONObject bodyJson = JSONObject.fromObject(bodyStr);

			vo.setBody(this.getMsg(bodyJson, itemName, className, itemClassName));
		} else {

			T body = (T) className.newInstance();
			vo.setBody(body);
		}
		JSONObject temp = JSONObject.fromObject(json);
		temp.remove("body");// 需要去掉，不然会报错
		// 获取报文头
		MsgReqHeaderVo header = (MsgReqHeaderVo) this.getMsg(temp, MsgReqHeaderVo.class);
		// 强制生成req_trans_id,用来区分不同交易
		header.setReq_trans_id(TransIdSerial.genSeqId("121"));// 121开头，随机
		vo.setHeader(header);

		return vo;
	}

	public T getMsg(JSONObject json, Map<String, Class> classMap, Class className) throws Exception {
		@SuppressWarnings("unchecked")
		T vo = (T) JSONObject.toBean(json, className, classMap);
		return vo;
	}

	public T getMsg(JSONObject json, String itemName, Class className, Class itemClassName) throws Exception {
		Map<String, Class> classMap = new HashMap<String, Class>();
		classMap.put(itemName, itemClassName);
		@SuppressWarnings("unchecked")
		T vo = (T) JSONObject.toBean(json, className, classMap);
		return vo;
	}

	/**
	 * 根据json，返回MsgVo，其中报文头的类固定，报文体的类根据className不同而不同
	 * 
	 * @param json
	 * @param className
	 * @return
	 * @throws Exception
	 */
	public ReqMsgVo getMsgVo(JSONObject json, Class className) throws Exception {
		ReqMsgVo vo = new ReqMsgVo();
		// 获取报文头
		MsgReqHeaderVo header = (MsgReqHeaderVo) this.getMsg(json, MsgReqHeaderVo.class);
		// 强制生成req_trans_id,用来区分不同交易
		header.setReq_trans_id(TransIdSerial.genSeqId("121"));// 121开头，随机
		vo.setHeader(header);

		// 获取报文体
		if (!StringUtils.isEmpty(json.get("body"))) {
			String bodyStr = json.get("body").toString(); // 先转为String，再统一转json(兼容body格式是JSONObject或字符串)

			JSONObject bodyJson = JSONObject.fromObject(bodyStr);

			vo.setBody(this.getMsg(bodyJson, className));
		} else {

			T body = (T) className.newInstance();
			vo.setBody(body);
		}

		return vo;
	}


	/**
	 * 根据json，返回MsgVo，无报文体
	 * 
	 * @param json
	 * @return
	 * @throws Exception
	 */
	public ReqMsgVo getMsgVo(JSONObject json) throws Exception {
		ReqMsgVo vo = new ReqMsgVo();
		/*
		 * 获取报文头
		 */
		MsgReqHeaderVo header = (MsgReqHeaderVo) this.getMsg(json, MsgReqHeaderVo.class);
		// 强制生成req_trans_id,用来区分不同交易
		header.setReq_trans_id(TransIdSerial.genSeqId("121"));// 121开头，随机
		vo.setHeader(header);
		return vo;
	}

	public T getEncMsgVo(JSONObject json, Class className) throws Exception {
		return this.getMsg(json, className);
	}

	public T getVoByParam(HttpServletRequest request, Class className) throws Exception {

		Class<?> clazz = Class.forName(className.getName());
		@SuppressWarnings("unchecked")
		T vo = (T) clazz.newInstance();
		BeanUtils.populate(vo, request.getParameterMap());
		return vo;

	}

	protected JSONObject getJson(EpaySDKRcv epaySDKRcv, JSONObject json) {

		if (epaySDKRcv != null) {
			// 解密后的报文重新组装成json
			JSONObject result = JSONObject.fromObject(epaySDKRcv.getMessage());
			result.put("ip", json.getString("ip"));

			json = result; // 如果加密，则返回解密后的
		}
		return json;// 如果没有加密，则返回原来的json
	}

}
