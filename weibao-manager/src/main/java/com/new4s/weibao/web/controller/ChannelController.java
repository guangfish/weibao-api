package com.new4s.weibao.web.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.new4s.weibao.common.web.PageConst;
import com.new4s.weibao.entity.Channel;
import com.new4s.weibao.service.IChannelService;
import com.new4s.weibao.util.DateUtil;
import com.new4s.weibao.util.StringUtil;
import com.new4s.weibao.vo.web.SearchDataVo;
import com.new4s.weibao.web.BasicController;
import com.new4s.weibao.web.controller.vo.JsonResult;
import com.new4s.weibao.web.util.SearchUtil;

/**
 * 渠道Controller
 */
@Controller
public class ChannelController extends BasicController {
	@Autowired
	IChannelService channelService;

	/**
	 * 渠道列表
	 * 
	 * @param model
	 * @param tag
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	@RequestMapping(value = "/channel/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		return PageConst.CHANNEL_LIST;
	}

	/**
	 * 增加渠道
	 * 
	 * @param model
	 * @param tag
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	@RequestMapping(value = "/channel/addoredit", method = { RequestMethod.GET, RequestMethod.POST })
	public String add(Model model, HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "id", required = false) Integer channelId) {
		if (channelId != null) {
			Channel channel = channelService.selectByID(channelId);
			model.addAttribute("channelid", channelId);
			model.addAttribute("channelname", channel.getChannelName());
			model.addAttribute("appsecret", channel.getAppsecret());
			model.addAttribute("validtime", DateUtil.dateFormate(channel.getValidTime(), DateUtil.CHINESE_PATTERN));
			model.addAttribute("province", channel.getProvince());
			model.addAttribute("city", channel.getCity());
			model.addAttribute("address", channel.getAddress());
			model.addAttribute("contacts", channel.getContacts());
			model.addAttribute("mobile", channel.getMobile());
		} else {
			String appsecret = (StringUtil.getUUID()).toUpperCase();
			model.addAttribute("appsecret", appsecret);
		}
		return PageConst.CHANNEL_ADD;
	}

	@ResponseBody
	@RequestMapping(value = "/api/channel/save", method = { RequestMethod.GET, RequestMethod.POST })
	public String save(Model model, HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "channelid", required = false) Integer channelId,
			@RequestParam(value = "channelname", required = false) String channelName,
			@RequestParam(value = "appsecret", required = false) String appsecret,
			@RequestParam(value = "validtime", required = false) String validTime,
			@RequestParam(value = "province", required = false) String province,
			@RequestParam(value = "province_name", required = false) String provinceName,
			@RequestParam(value = "city", required = false) String city,
			@RequestParam(value = "city_name", required = false) String cityName,
			@RequestParam(value = "address", required = false) String address,
			@RequestParam(value = "people", required = false) String contacts,
			@RequestParam(value = "mobile", required = false) String mobile) {

		Channel channel = new Channel();
		if (channelId != null) {
			channel = channelService.selectByID(channelId);
		} else {
			channel.setCreateTime(new Date());
		}
		channel.setAppsecret(appsecret);
		channel.setChannelName(channelName);
		channel.setMobile(mobile);
		channel.setContacts(contacts);
		channel.setUpdateTime(new Date());
		if (validTime != null) {
			channel.setValidTime(DateUtil.getDate(validTime));
		}
		if (province != null) {
			channel.setProvince(province);
		}
		if (provinceName != null) {
			channel.setProvinceName(provinceName);
		}
		if (city != null) {
			channel.setCity(city);
		}
		if (cityName != null) {
			channel.setCityName(cityName);
		}
		if (address != null) {
			channel.setAddress(address);
		}
		if (channelId != null) {
			channelService.update(channel);
		} else {
			channelService.insert(channel);
		}
		return "success";
	}

	@ResponseBody
	@RequestMapping(value = "/api/channel/list", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult getChannelList(@RequestParam(value = "searchcondition", required = false) String searchCondition,
			@RequestParam(value = "channelname", required = false) String channelName,
			@RequestParam(value = "province", required = false) String province,
			@RequestParam(value = "city", required = false) String city) {
		SearchDataVo vo = SearchUtil.getVo();
		JsonResult result = new JsonResult();
		if (searchCondition != null) {
			if ("channelname".equals(searchCondition)) {
				if (channelName != null) {
					vo.putSearchParam("channelName", channelName, channelName);
				}
			} else if ("province-city".equals(searchCondition)) {
				if (province != null) {
					vo.putSearchParam("province", province, province);
				}
				if (city != null) {
					vo.putSearchParam("city", city, city);
				}
			}
		}
		channelService.selectChannelList(vo);
		// List<Channel> channelList = channelService.selectAll();
		result.setTotal(vo.getCount() + "");
		result.setRows(vo.getList());
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/channel/appsecret", method = { RequestMethod.GET, RequestMethod.POST })
	public String appsecret(Model model) {
		return StringUtil.getUUID().toUpperCase();
	}
}
