package com.dzdy.springBoot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * session共享
 * @author wangzhiyong
 *
 */
@Configuration
//设置Session失效时间，使用Redis Session之后，原Boot的server.session.timeout属性不再生效
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400*30)
public class SessionConfig {
	
}
