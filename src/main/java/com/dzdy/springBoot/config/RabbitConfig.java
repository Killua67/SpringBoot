package com.dzdy.springBoot.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Rabbit 消息队列
 * @author wangzhiyong
 *
 */
@Configuration
public class RabbitConfig {
	
	@Bean
    public Queue Queue() {
        return new Queue("hello");
    }
}
