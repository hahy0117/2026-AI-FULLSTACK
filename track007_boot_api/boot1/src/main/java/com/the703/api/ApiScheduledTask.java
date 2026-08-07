package com.the703.api;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class ApiScheduledTask {

//	@Scheduled (fixedRate =2000) //2초마다
//	public void runTest1() {
//		System.out.println("/........ 스케쥴러 실행중:"+System.currentTimeMillis());
//	}
//	
	/*
	 * //년 월 일 시 분 초 <-
	 * 
	 * @Scheduled (cron ="0 20 11 * * ?") //초 분 시 일 년 월 일 요일 public void runTest1()
	 * { System.out.println("/........ 스케쥴러 실행중:"+System.currentTimeMillis()); }
	 */
	
}
