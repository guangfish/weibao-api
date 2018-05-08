package com.new4s.weibao.api.task;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component
public class DemoTask {
	private static final Logger logger = Logger.getLogger(DemoTask.class);

	// 每隔一段执行一次
	@Scheduled(cron = "0/10 * * * * ?")
	public void getCommission() {
		logger.info("开始执行任务");
	}

	public static void main(String[] args) throws Exception {
		String[] cfgs = new String[] { "classpath:spring/applicationContext.xml" };
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext(cfgs);
		((DemoTask) ctx.getBean("demoTask")).getCommission();
	}
}
