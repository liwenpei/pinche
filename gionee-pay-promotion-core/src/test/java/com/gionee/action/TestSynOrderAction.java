package com.gionee.action;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import net.minidev.json.JSONObject;
import net.minidev.json.JSONStyle;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.util.StringUtils;

import com.gionee.common.TestBaseAction;
import com.gionee.common.utils.TransIdSerial;

/**
 * @author dingyw
 *
 * 2016年7月27日
 */
public class TestSynOrderAction extends TestBaseAction{
	Logger logger = LoggerFactory.getLogger(getClass());

	private JmsTemplate jmsTemplate;

	private Destination destination;
	
	private Destination reply_destination;
	
	String brokerURL="failover:(tcp://42.121.96.143:61616,tcp://42.121.96.143:61616)?randomize=false";
	String userName="risk_mq";
	String password="2015@RiskMQ";
	
	String send_queue_name="local_pay_to_promotion_order_req_queue";
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
	public void execute() {
		
		init(); //初始化
		//是否采用本地环境还是测试环境
		this.setEnv("local");
		
		this.setTrans_code("170001");
		JSONObject jsonReq = this.getHeader();
		
		JSONObject jsonBody = new JSONObject();
		
		jsonBody.put("order_no", TransIdSerial.genRandomSeqId());
		jsonBody.put("tradeNo", "123456789");
		jsonBody.put("thirdTransactionNo", "987654321");
		jsonBody.put("pay_channel", "108");
		jsonBody.put("amount", "2000");
		jsonBody.put("app_id", "wxb3f0e6db6e77ec11");
		jsonBody.put("outOrderNo", "888888888");
		jsonBody.put("tran_type", "2");
		//jsonBody.put("user_id", "liwenpei");
		jsonBody.put("mch_id", "1288553001");
		jsonBody.put("third_user_id", "oTmxdt005R6whZs0HvTLAoJSI0_w");
		jsonBody.put("create_time", "20160804220000");
		jsonBody.put("trans_time", "20160804220000");
		
		jsonReq.put("body", jsonBody);
		
		String req_plain=jsonReq.toJSONString(JSONStyle.NO_COMPRESS);
		System.out.println(req_plain);
		this.sendMsg(req_plain);
		
	}
	
	static int count = 0;
	public static void main(String[] args) {
		
	
		
		for(int i = 0; i < 100; i++){
			new Thread(){
				@Override
				public void run(){
					if(lastTime == 0){
						lastTime = System.currentTimeMillis();
					}
					convertStr("123456789");
					count ++;
					
					if(count == 99){
						System.out.println(System.currentTimeMillis() - lastTime);
					}
				}
			}.start();
		}
	}
	
	static long lastTime = 0;
	
	
	public static  synchronized  String convertStr(String str){
		
		System.out.println("==============================");
		StringBuffer buff = new StringBuffer();
		buff.append(str.substring(0,1));
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		buff.append(str.substring(1,2));
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		buff.append(str.substring(2,3));
		System.out.println(buff.toString());
		System.out.println("==============================");
		return buff.toString();
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
