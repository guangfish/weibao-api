package com.new4s.weibao.api.task;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.new4s.weibao.dao.entity.TaskRecord;
import com.new4s.weibao.dao.entity.YqQueryWithBLOBs;
import com.new4s.weibao.dao.service.ITaskRecordService;
import com.new4s.weibao.dao.service.IYqQueryService;

/**
 * 
 * @author 维保任务的定时查询，调用下游的回调接口
 *
 */

@Component
public class WeibaoTaskSearchTask {
	private static final Logger logger = Logger.getLogger(WeibaoTaskSearchTask.class);

	@Autowired
	ITaskRecordService taskRecordService;

	@Autowired
	IYqQueryService yqQueryService;

	// 每隔一段执行一次
	@Scheduled(cron = "0/10 * * * * ?")
	public void getCommission() {
		logger.info("开始执行任务");
		// 找任务未执行完毕的数据
		List<TaskRecord> taskRecordList = taskRecordService.selectByStatus(1);
		if (taskRecordList != null && taskRecordList.size() > 0) {
			YqQueryWithBLOBs yqQueryWithBLOBs = null;
			for (TaskRecord taskRecord : taskRecordList) {
				// 查询yq_query表
				yqQueryWithBLOBs = yqQueryService.selectByVin(taskRecord.getVinCode());
				if (yqQueryWithBLOBs != null) {
					// 调用回调地址
					try{
						
					}catch(Exception e){
						e.printStackTrace();
						//调用回调地址失败，立即返回
						continue;
					}

					//更新任务状态
					taskRecord.setStatus(2);
					taskRecordService.updateByPrimaryKey(taskRecord);
				}else{
					logger.info("从qy_query表中未找到数据，或爬虫任务正在执行中");
				}
			}
		}else{
			logger.info("所有任务列表数据已完成");
		}
	}

	public static void main(String[] args) throws Exception {
		String[] cfgs = new String[] { "classpath:spring/applicationContext.xml" };
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext(cfgs);
		((WeibaoTaskSearchTask) ctx.getBean("weibaoTaskSearchTask")).getCommission();
	}
}
