package com.dzdy.springBoot.config;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息队列(hello) 接受者
 * @author wangzhiyong
 *
 */
@Component
@RabbitListener(queues="hello")
public class HelloReceiver {
	
	@RabbitHandler
	public void process(String hello){
		System.err.println("Receiver:"+hello);
	}
}
