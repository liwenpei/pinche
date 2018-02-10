package com.gionee.common.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.gionee.common.msg.MsgReqHeaderVo;
import com.gionee.common.msg.ReqMsgVo;
import com.gionee.common.utils.TransIdSerial;
import com.gionee.common.vo.BaseMsgVo;
import com.gionee.pay.promotion.core.service.txn.OrderTxnService;
import com.gionee.pay.promotion.service.synOrder.check.CommomServiceCheckFacade;
import com.google.gson.Gson;

import net.sf.json.JSONObject;

/**
 * @author dingyw
 * 
 *         2015年11月5日
 */
public abstract class AbsBaseAction<T> implements IBaseAction<T> {
	Logger log = LoggerFactory.getLogger(getClass());
	/**
	 * 公共校验类
	 */
	@Autowired
	protected CommomServiceCheckFacade commomServiceCheckFacade;
	
	/**
	 *订单事务层 
	 */
	@Autowired
	protected OrderTxnService orderTxnService;
	
	public BaseMsgVo doAction(JSONObject json)throws Exception{ //由子类覆盖
		return null;
	}
	/**子类覆盖该类，实现返回报文是否需要签名
	 * @return
	 */
	public boolean is_need_sign(){
		return false;
	}
	/**子类覆盖该类，实现返回报文是否需要加密
	 * @return
	 */
	public boolean is_need_encry(){
		return false;
	}
	public T getMsg(JSONObject json, Class className) throws Exception {
		@SuppressWarnings("unchecked")
		T vo = (T) JSONObject.toBean(json, className);
		return vo;
	}

	/**
	 * 由于net.sf.json.JSONObject在处理首字母大写上存在问题，转用google json
	 * 
	 * @param json
	 * @param className
	 * @return
	 * @throws Exception
	 */
	public T getVoByGoogleJson(JSONObject json, Class className) throws Exception {
		Gson gson = new Gson();
		T vo = (T) gson.fromJson(json.toString(), className);
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
		
		//获取报文体
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
		return this.getMsg(json,className);
	}

	public T getVoByParam(HttpServletRequest request, Class className) throws Exception {

		Class<?> clazz = Class.forName(className.getName());
		@SuppressWarnings("unchecked")
		T vo = (T) clazz.newInstance();
		BeanUtils.populate(vo, request.getParameterMap());
		return vo;

	}

}
