package com.dzdy.springBoot.config;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消息队列(hello)发送者
 * @author wangzhiyong
 *
 */
@Component
public class HelloSender {

	@Autowired
	private AmqpTemplate template;
	
	public void send(){
		String content = "hello," + new Date();
		System.out.println("Sender:"+content);
		this.template.convertAndSend("hello",content);
	}
}
