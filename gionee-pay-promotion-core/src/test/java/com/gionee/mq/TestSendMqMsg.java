
package com.gionee.mq;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.util.StringUtils;


public class TestSendMqMsg {

	Logger logger = LoggerFactory.getLogger(getClass());

	private JmsTemplate jmsTemplate;

	private Destination destination;
	
	private Destination reply_destination;
	
	String brokerURL="failover:(tcp://42.121.96.143:61616,tcp://42.121.96.143:61616)?randomize=false";
	String userName="risk_mq";
	String password="2015@RiskMQ";
	
	String send_queue_name="pay_to_promotion_order_req_queue";
	String reply_queue_name="";

	public void init(){

		ActiveMQConnectionFactory activeMQConnectionFactory=new ActiveMQConnectionFactory(userName,  password,brokerURL);
		
		PooledConnectionFactory pooledConnectionFactory=new PooledConnectionFactory(activeMQConnectionFactory);
		
		jmsTemplate=new org.springframework.jms.core.JmsTemplate(pooledConnectionFactory);
		
		destination=new ActiveMQQueue(send_queue_name); //根据子类指定的队列名称初始化发送消息队列
		//如果同步发送，需要子类设置reply_queue_name
		if(!StringUtils.isEmpty(reply_queue_name)){
			reply_destination=new ActiveMQQueue(reply_queue_name);
		}	
	}
	
	public void sendMsg(final String content){
		jmsTemplate.send(destination, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				Message msg = session.createTextMessage(content);
				return msg;
			}
		});
	}
	public static void main(String[] args) {
		TestSendMqMsg t=new TestSendMqMsg();
		t.init();
		t.sendMsg("hello");
		
	}
	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	public Destination getDestination() {
		return destination;
	}
	public void setDestination(Destination destination) {
		this.destination = destination;
	}
	
}

