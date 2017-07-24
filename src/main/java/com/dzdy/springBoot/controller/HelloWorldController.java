package com.dzdy.springBoot.controller;

import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dzdy.springBoot.domain.User;
import com.dzdy.springBoot.domain.User2;
import com.dzdy.springBoot.mapper.UserRepository;

//@RestController的意思就是controller里面的方法都以json格式输出
@RestController
public class HelloWorldController {
	
	protected static Logger logger=LoggerFactory.getLogger(HelloWorldController.class);
	
	@Autowired
	private User2 user; 

	@Resource
	private UserRepository userRepository;
	
	@RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }
	
	@RequestMapping("/getUser")
	public User2 getUser(){
		//测试配置文件信息
		return user;
	}

	//测试redis 缓存
	@RequestMapping("/getUser2")
	@Cacheable(value="user-key")
	public User getUse2r() {
	    User user=userRepository.findByUserName("admin");
	    System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");  
	    return user;
	}
	
	@RequestMapping("/save")
	public boolean save(User user){
		Boolean result = false;
		try {
			User save = userRepository.save(user);
			logger.info("UserId:"+save.getId());
			result = true;
		} catch (Exception e) {
			logger.error("saveError",e);
			e.printStackTrace();
		}
		return result;
	}
	//测试session共享
	@RequestMapping("/uid")
    String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }
	
}
