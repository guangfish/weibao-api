package com.new4s.weibao.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.new4s.weibao.entity.District;
import com.new4s.weibao.service.IDistrictService;
import com.new4s.weibao.web.BasicController;
import com.new4s.weibao.web.controller.vo.JsonResult;

/**
 * 通用API接口Controller
 */
@Controller
public class DistrictController extends BasicController {
	@Autowired
	IDistrictService districtService;

	/**
	 * 省市区联动接口
	 * 
	 * @param level
	 * @param pid
	 * @return json
	 */
	@ResponseBody
	@RequestMapping(value = "/api/district", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult getChannelList(@RequestParam(value = "level", required = true) String level,
			@RequestParam(value = "pid", required = false) String pid) {
		JsonResult result = new JsonResult();
		Map<String, Object> searchMap = new HashMap<String, Object>();
		searchMap.put("level", level);
		if (pid != null) {
			searchMap.put("upid", pid);
		}

		List<District> districtList = districtService.selectByLevel(searchMap);
		result.setTotal(districtList.size() + "");
		result.setRows(districtList);
		return result;
	}

}
