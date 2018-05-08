package com.new4s.weibao.api.controller.jsonp;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.new4s.weibao.api.vo.JsonResult;
import com.new4s.weibao.dao.entity.TaskRecord;
import com.new4s.weibao.dao.service.ITaskRecordService;
import com.new4s.weibao.dao.vo.TaskVo;
import com.new4s.weibao.util.DateUtil;

@RestController
public class WeibaoRecordController {

	@Autowired
	ITaskRecordService taskRecordService;

	@ResponseBody
	@RequestMapping(value = "/task")
	public JsonResult sendTask(@RequestParam(value = "channelid", required = true) Integer channelId,
			@RequestParam(value = "appsecret", required = true) String appsecret,
			@RequestParam(value = "vin", required = true) String vin) {
		JsonResult result = new JsonResult();
		TaskVo taskVo = new TaskVo();
		taskVo.setVinCode(vin);
		taskVo.setTaskTime(DateUtil.dateFormate(new Date(), DateUtil.FULL_CHINESE_PATTERN));
		// 调用爬虫任务接口

		// 调用爬虫任务后任务信息入库
		TaskRecord taskRecord = new TaskRecord();
		taskRecord.setChannelId(channelId);
		taskRecord.setAppsecret(appsecret);
		taskRecord.setStatus(1);
		taskRecord.setVinCode(vin);
		taskRecord.setCreateTime(new Date());
		taskRecord.setUpdateTime(new Date());
		taskRecordService.insert(taskRecord);

		result.setCode(100);
		result.setMsg("任务发送成功");
		result.setResult(taskVo);
		return result;
	}

}
