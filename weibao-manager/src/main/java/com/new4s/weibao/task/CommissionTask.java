package com.new4s.weibao.task;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@Component
public class CommissionTask {
	private static final Logger logger = Logger.getLogger(CommissionTask.class);

	@Value("${commission.get.url}")
	private String commissionUrl;

	// 每隔一段时间获取一次佣金信息
	// @Scheduled(cron = "0/10 * * * * ?")
	public void getCommission() {
		logger.info("定时查询佣金信息");
	}

	public static void main(String[] args) throws Exception {
		String[] cfgs = new String[] { "classpath:spring/applicationContext.xml" };
		ApplicationContext ctx = new ClassPathXmlApplicationContext(cfgs);
		((CommissionTask) ctx.getBean("commissionTask")).getCommission();
	}
}
