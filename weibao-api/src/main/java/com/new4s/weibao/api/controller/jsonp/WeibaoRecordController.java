package com.new4s.weibao.api.controller.jsonp;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.new4s.weibao.api.system.GlobalVariable;
import com.new4s.weibao.api.vo.JsonResult;
//import com.new4s.weibao.dao.entity.Channel;
import com.new4s.weibao.dao.entity.YqOrder;
import com.new4s.weibao.dao.service.IChannelService;
import com.new4s.weibao.dao.service.IYqOrderService;
import com.new4s.weibao.dao.vo.TaskVo;
import com.new4s.weibao.util.DateUtil;
import com.new4s.weibao.util.StringUtil;

@RestController
public class WeibaoRecordController {

	@Autowired
	IYqOrderService yqOrderService;

	@Autowired
	IChannelService channelService;

	@Autowired
	StringRedisTemplate redisTemplate;

	@ResponseBody
	@RequestMapping(value = "/placeAnOrder", method = { RequestMethod.GET,
			RequestMethod.POST }, consumes = "application/x-www-form-urlencoded")
	public JsonResult placeAnOrder(@RequestParam(value = "channelid", required = false) String channelId,
			@RequestParam(value = "appsecret", required = false) String appsecret,
			@RequestParam(value = "vin", required = false) String vin) {
		JsonResult result = new JsonResult();
		if (StringUtil.isEmpty(channelId)) {
			result.setCode(101);
			result.setMsg("请求中缺少渠道ID");
			return result;
		}
		if (StringUtil.isEmpty(appsecret)) {
			result.setCode(102);
			result.setMsg("请求中缺少密匙");
			return result;
		}
		if (StringUtil.isEmpty(vin)) {
			result.setCode(103);
			result.setMsg("请求中缺少VIN码");
			return result;
		}

		// Channel channel = channelService.select(Integer.parseInt(channelId));
		// 查内存中渠道数据
		String allowAppsecret = GlobalVariable.channelMap.get(channelId);
		if (StringUtil.isEmpty(allowAppsecret)) {
			result.setCode(104);
			result.setMsg("渠道ID不正确");
			return result;
		} else {
			if (!appsecret.equals(allowAppsecret)) {
				result.setCode(105);
				result.setMsg("密匙不正确");
				return result;
			}
		}

//		redisTemplate.opsForValue().set(channelId, appsecret, 60 * 10, TimeUnit.SECONDS);
//		System.out.println(redisTemplate.opsForValue().get(channelId));

		TaskVo taskVo = new TaskVo();
		taskVo.setVinCode(vin);
		taskVo.setOrderTime(DateUtil.dateFormate(new Date(), DateUtil.FULL_CHINESE_PATTERN));

		// 订单入库
		YqOrder yqOrder = new YqOrder();
		yqOrder.setChannelId(Integer.parseInt(channelId));
		yqOrder.setOrderId(StringUtil.getUUID());
		yqOrder.setVin(vin);
		yqOrder.setTime(System.currentTimeMillis());
		yqOrder.setStatus(0);
		yqOrder.setCreateTime(new Date());
		yqOrder.setUpdateTime(new Date());
		yqOrderService.insert(yqOrder);

		result.setCode(100);
		result.setMsg("订单创建成功");
		result.setResult(taskVo);
		return result;
	}

}
