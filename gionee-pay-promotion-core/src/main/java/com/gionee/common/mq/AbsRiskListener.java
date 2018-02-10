package com.gionee.common.mq;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.gionee.common.constant.CommonConstant;
import com.gionee.common.exception.BizException;
import com.gionee.common.exception.NotRollBackBizException;
import com.gionee.common.msg.MsgRspHeaderVo;
import com.gionee.common.utils.MsgUtils;
import com.gionee.common.vo.BaseMsgVo;

/**
 * @author dingyw
 *
 * 2015年12月31日
 */
public abstract class AbsRiskListener extends AbsCommonRiskListener{
	
	
	/**
	 * 返回的jms队列 template
	 */
	@Autowired
	private JmsTemplate jmsTemplate;
	
	/**
	 *RspMsgVo标准规范的报文，返回标准的json报文，正常的响应报文
	 * 
	 * @param resp
	 * @param baseMsgVo
	 */
	public void printJsonResponse(Message message,BaseMsgVo baseMsgVo) {
		//获取返回队列
		Destination reply_destination;
		try {
			reply_destination = message.getJMSReplyTo();
			if (reply_destination == null) {
				return;
			}
		} catch (JMSException e1) {
			e1.printStackTrace();
		}
		try {
			String result =MsgUtils.beanToJsonStr(baseMsgVo);
			this.printJsonResponse(message, result);
		} catch (Exception e) {
			log.error(e.getMessage(),e); 
		}
	}
	/**
	 * 异常响应报文
	 * 
	 * @param resp
	 * @param e
	 */
	public void printJsonResponse(Message message, BizException e) {
		//获取返回队列
		Destination reply_destination;
		try {
			reply_destination = message.getJMSReplyTo();
			if (reply_destination == null) {
				return;
			}
		} catch (JMSException e1) {
			e1.printStackTrace();
		}
		
		MsgRspHeaderVo vo = MsgUtils.getCommonHeader(); //设置一般的报文头属性
		vo.setRsp_code(e.getRsp_code());
		vo.setRsp_desc(e.getRsp_desc());	
		this.getRspJsonMsg(message, vo);
	}
	/**
	 * 异常的响应报文
	 * 
	 * @param resp
	 * @param e
	 */
	public void printJsonResponse(Message message, NotRollBackBizException e) {
		//获取返回队列
		Destination reply_destination;
		try {
			reply_destination = message.getJMSReplyTo();
			if (reply_destination == null) {
				return;
			}
		} catch (JMSException e1) {
			e1.printStackTrace();
		}
		
		MsgRspHeaderVo header =MsgUtils.getCommonHeader(); //设置一般的报文头属性
		header.setRsp_code(e.getRsp_code());
		header.setRsp_desc(e.getRsp_desc());
		this.getRspJsonMsg(message, header);
	}
	public void getRspJsonMsg(Message message,MsgRspHeaderVo header){
		JSONObject jsonResp = JSONObject.fromObject(header);
		JSONObject jsonbody = new JSONObject(); //构造空的body
		jsonResp.put("body", jsonbody);
		this.printJsonResponse(message, jsonResp.toString());		
	}
	public void printJsonResponse(Message message,final String result){	
		//获取返回队列
		Destination reply_destination=null;
		String msg_id=null;
		try {
			reply_destination = message.getJMSReplyTo();
			msg_id=message.getStringProperty(CommonConstant.SEQ_TYPE.MID_SEQ.getValue());
			if (reply_destination == null) {
				return;
			}
		} catch (JMSException e1) {
			e1.printStackTrace();
		}
		log.info("begin send back message:{}", result);
		final String msgId=msg_id;
		try{
			if (reply_destination != null) {
				jmsTemplate.send(reply_destination, new MessageCreator() {
					public Message createMessage(Session session)
							throws JMSException {
						Message msg = session.createTextMessage(result);
						msg.setStringProperty(CommonConstant.SEQ_TYPE.MID_SEQ.getValue(), msgId);
						return msg;
					}
				});
				log.info("send back message:{} finished", result);
			}
		}catch (Exception ex) {
			ex.printStackTrace();
			log.error(ex.getMessage(),ex); 
		}
	}

	/**
	 *请求异常的响应报文
	 * 
	 * @param resp
	 * @param e
	 */
	public void printJsonResponse(Message message, Exception e) {
		BizException bizE = new BizException(
				CommonConstant.RSP_CODE.FAILED.getValue(),"系统异常");
		this.printJsonResponse(message, bizE);
	}


}
