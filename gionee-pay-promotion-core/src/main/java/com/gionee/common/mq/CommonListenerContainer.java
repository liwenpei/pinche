package com.gionee.common.mq;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.stereotype.Component;

/**
 * @author dingyw
 *
 * 2016年7月27日
 */
@Component
public class CommonListenerContainer {
	
	/**
	 * 将所有消息队列管控起来的list
	 */
	private List <DefaultMessageListenerContainer>list;
	
	/**
	 *jms连接工厂 
	 */
	@Autowired
	ConnectionFactory connectionFactory;
	
	/**
	 * 监听器 
	 */
	@Autowired
	FacadeCommonListener facadeCommonListener;
	
	/**
	 * 请求队列名称,用逗号隔开
	 */
	private String common_req_queue;
	
	/**
	 * 请求队列的消费者个数，用逗号隔开
	 */
	private String common_req_queue_concurrent_consumer;
	
	/**
	 * 请求队列的最大消费者个数，用逗号隔开
	 */
	private String common_req_queue_max_consumer;
	
	/**
	 * 公共队列属性
	 */
	private String common_queue_prop;
	
	@PostConstruct
	public void init(){
		
		String []common_req_queue_array=common_req_queue.split(",");
		String []common_req_queue_max_consumer_array=common_req_queue_max_consumer.split(",");
		String []common_req_queue_concurrent_consumer_array=common_req_queue_concurrent_consumer.split(",");
		
		//初始list
		list=new ArrayList<DefaultMessageListenerContainer>();
		
		for(int i=0;i<common_req_queue_array.length;i++){
			DefaultMessageListenerContainer container=new DefaultMessageListenerContainer();
			//设置连接工厂
			container.setConnectionFactory(connectionFactory);
			//队列名+队列属性
			String queue_name=common_req_queue_array[i]+common_queue_prop;
			Destination rcv_destination=new ActiveMQQueue(queue_name); //根据子类指定的队列名称初始化接收消息队列
			container.setDestination(rcv_destination);
			//设定监听器
			container.setMessageListener(facadeCommonListener);
			//设置最大消费者数量
			container.setMaxConcurrentConsumers(Integer.parseInt(common_req_queue_max_consumer_array[i]));
			//设置最初的消费者数量
			container.setConcurrentConsumers(Integer.parseInt(common_req_queue_concurrent_consumer_array[i]));
			
			//必须调用afterPropertiesSet,在spring中不需要，容器会默认调用，但手工创建需要调用
			container.afterPropertiesSet();
			container.start();
			//添加到列表中
			list.add(container);
		}
	}

	public String getCommon_req_queue() {
		return common_req_queue;
	}

	@Value("#{jms_config.common_req_queue}")
	public void setCommon_req_queue(String common_req_queue) {
		this.common_req_queue = common_req_queue;
	}

	public String getCommon_req_queue_concurrent_consumer() {
		return common_req_queue_concurrent_consumer;
	}

	@Value("#{jms_config.common_req_queue_concurrent_consumer}")
	public void setCommon_req_queue_concurrent_consumer(
			String common_req_queue_concurrent_consumer) {
		this.common_req_queue_concurrent_consumer = common_req_queue_concurrent_consumer;
	}

	public String getCommon_req_queue_max_consumer() {
		return common_req_queue_max_consumer;
	}

	@Value("#{jms_config.common_req_queue_max_consumer}")
	public void setCommon_req_queue_max_consumer(
			String common_req_queue_max_consumer) {
		this.common_req_queue_max_consumer = common_req_queue_max_consumer;
	}

	public String getEpay_to_risk_common_queue_prop() {
		return common_queue_prop;
	}
	@Value("#{jms_config.common_queue_prop}")
	public void setCommon_queue_prop(
			String common_queue_prop) {
		this.common_queue_prop = common_queue_prop;
	}
}
