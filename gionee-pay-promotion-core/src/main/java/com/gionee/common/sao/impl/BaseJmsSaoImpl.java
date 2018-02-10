package com.gionee.common.sao.impl;
import javax.annotation.PostConstruct;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import net.sf.json.JSONObject;

import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.util.StringUtils;

import com.gionee.common.constant.CommonConstant;
import com.gionee.common.exception.BizException;
import com.gionee.common.utils.MsgUtils;
import com.gionee.common.utils.SeqIdSerial;

/**
 * @author dingyw
 *
 * 2015年12月4日
 */
public abstract class BaseJmsSaoImpl {
	
	Logger log = LoggerFactory.getLogger(getClass());
	/**
	 * jms发送的template
	 */
	@Autowired
	private JmsTemplate template;
	/**
	 * 发送的队列，由子类决定
	 */
	private Destination destination;
	
	/**
	 * 接收的队列，由子类决定
	 */
	private Destination reply_destination;
	
	
	@PostConstruct
	public void init(){
		destination=new ActiveMQQueue(send_queue_name); //根据子类指定的队列名称初始化发送消息队列
		//如果同步发送，需要子类设置reply_queue_name
		if(!StringUtils.isEmpty(reply_queue_name)){
			reply_destination=new ActiveMQQueue(reply_queue_name);
		}
	}
	/**
	 * 发送队列名
	 */
	protected String send_queue_name;
	
	/**
	 * 返回队列
	 */
	protected String reply_queue_name;
	

	/**异步发送接口实现
	 * @param msg
	 */
	public void sendMsg(final String content) throws BizException{
		try{
		//log.debug("BaseJmsSaoImpl sendJmsMsg->"+content); //防止身份证号信息泄露，不写日志
		template.send(destination, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				Message msg = session.createTextMessage(content);
				return msg;
			}
		});
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage(),e);
			throw new BizException("发送jms异常");
		}
		
	}
	/**同步发送接口实现
	 * @param msg
	 */
	public void synSendMsg(final String content) throws BizException{
		try{
		//log.debug("BaseJmsSaoImpl sendJmsMsg->"+content);//防止身份证号信息泄露，不写日志
		
		final String msgId=SeqIdSerial.genSeqId(CommonConstant.SEQ_TYPE.MID_SEQ.getValue());
		
		template.send(destination, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				Message msg = session.createTextMessage(content);
				msg.setJMSReplyTo(reply_destination);
				msg.setStringProperty(CommonConstant.SEQ_TYPE.MID_SEQ.getValue(), msgId);
				return msg;
			}
		});
		//从返回队列里面取消息，同步等待
		this.getReplyMsg(msgId);
		
		}catch(BizException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage(),e);
			throw new BizException("发送jms异常");
		}
		
	}
	private void getReplyMsg(String msgId) throws BizException{
		String msg=null;
		try {
			TextMessage respMsg = (TextMessage) template.receiveSelected(reply_destination,
					CommonConstant.SEQ_TYPE.MID_SEQ.getValue() + "='" + msgId + "'");
			if(respMsg==null){
				throw new BizException("接收系统异常");
			}
			if(StringUtils.isEmpty(respMsg.getText())){
				throw new BizException("接收系统返回异常");
			}
			log.info("respMsg-->"+respMsg.getText());
			msg=respMsg.getText();
		} catch (JMSException e) {
			e.printStackTrace();
			log.error(e.getMessage(),e);
			throw new BizException("接收系统异常");
		}
		//分析返回报文
		this.analyzeReplyMsg(msg);
	}
	private void analyzeReplyMsg(String msg) throws BizException{
		//解析返回的报文，如果返回失败，则抛出异常
		JSONObject result=null;
		try {
			 result=MsgUtils.getJSONObject(msg);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(),e);
			throw new BizException("接收返回报文异常");
		}		
		String rsp_code=result.getString("rsp_code");
		String rsp_desc=result.getString("rsp_desc");
		
		if(CommonConstant.RSP_CODE.SUCCESS.getValue().equals(rsp_code)){ //成功返回
			return;
		}else{
			throw new BizException(rsp_code,rsp_desc);
		}
	}
	public String getSend_queue_name() {
		return send_queue_name;
	}

	public String getReply_queue_name() {
		return reply_queue_name;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}
}
