package com.dzdy.springBoot;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.dzdy.springBoot.config.HelloSender;
import com.dzdy.springBoot.domain.User;
import com.dzdy.springBoot.service.MailService;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

//	private MockMvc mvc;
//    @Before
//    public void setUp() throws Exception {
//        mvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
//    }
//    @Test
//    public void getHello() throws Exception {
//    mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print())
//                .andReturn();
//    }
	
//	@Autowired
//	private UserRepository userRepository;
//
//	@Test
//	public void test() throws Exception {
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);        
//		String formattedDate = dateFormat.format(date);
//		
////		userRepository.save(new User("aa11", "aa1234561","aa@126.com1", "aa1", formattedDate));
////		userRepository.save(new User("bb21", "bb1234561","bb@126.com1", "bb1", formattedDate));
////		userRepository.save(new User("cc31", "cc1234561","cc@126.com1", "cc1", formattedDate));
//
//		Assert.assertEquals(6, userRepository.findAll().size());
//		Assert.assertEquals("bb", userRepository.findByUserNameOrEmail("bb2", "bb@126.com").getNickName());
//		userRepository.delete(userRepository.findByUserName("aa1"));
//	}
	
//	@Autowired
//    private StringRedisTemplate stringRedisTemplate;
//    
//	@Autowired
//	private RedisTemplate redisTemplate;
//
//    
//    @Test
//    public void testObj() throws Exception {
//        User user=new User( "aa", "aa123456", "aa","aa@126.com","123");
//        ValueOperations<String, User> operations=redisTemplate.opsForValue();
//        operations.set("com.neox", user);
//        operations.set("com.neo.f", user,1,TimeUnit.SECONDS);
//        Thread.sleep(1000);
//        //redisTemplate.delete("com.neo.f");
//        boolean exists=redisTemplate.hasKey("com.neo.f");
//        if(exists){
//        	System.out.println("exists is true");
//        }else{
//        	System.out.println("exists is false");
//        }
//       // Assert.assertEquals("aa", operations.get("com.neo.f").getUserName());
//    }
//
//    @Test
//    public void test() throws Exception {
//    	stringRedisTemplate.opsForValue().set("aaa", "111");
//    	Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
//    }
	
//	@Autowired
//	private HelloSender helloSender;
//	
//	@Test
//	public void hello() {
//		try {
//			helloSender.send();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	@Autowired
    private MailService MailService;
	@Autowired
	private TemplateEngine templateEngine;

    @Test
    public void testSimpleMail() throws Exception {
//    	String content="<html>\n" +
//                "<body>\n" +
//                "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
//                "</body>\n" +
//                "</html>";
    	Context content = new Context();
    	content.setVariable("id", "007");
    	String emailContent = templateEngine.process("emailTemplate", content);
        MailService.sendHtmlMail("794448502@qq.com","test html mail",emailContent);
//        MailService.sendSimpleMail("794448502@qq.com","test simple mail"," hello this is simple mail");
    }
}
