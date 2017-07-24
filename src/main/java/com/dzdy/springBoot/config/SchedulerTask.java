package com.dzdy.springBoot.config;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * 定时器
 * @author wangzhiyong
 *
 */
@Component
public class SchedulerTask {
	private int count = 1;
	/*
	@Scheduled(fixedRate = 6000) ：上一次开始执行时间点之后6秒再执行
	@Scheduled(fixedDelay = 6000) ：上一次执行完毕时间点之后6秒再执行
	@Scheduled(initialDelay=1000, fixedRate=6000) ：第一次延迟1秒后执行，之后按fixedRate的规则每6秒执行一次
	*/
//	@Scheduled(cron="*/6 * * * * ?")
	private void process(){
		System.out.println("this is scheduler task runing  "+(count++));
	}
	
	SimpleDateFormat dataFormate = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
	
//	@Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println("现在时间：" + dataFormate.format(new Date()));
    }
}
