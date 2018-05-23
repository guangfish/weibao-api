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
import com.new4s.weibao.entity.DealerInfo;
import com.new4s.weibao.service.IDealerInfoService;
import com.new4s.weibao.vo.web.SearchDataVo;
import com.new4s.weibao.web.BasicController;
import com.new4s.weibao.web.controller.vo.JsonResult;
import com.new4s.weibao.web.util.SearchUtil;

/**
 * 经销商管理Controller
 */
@Controller
public class DealerController extends BasicController {
	@Autowired
	IDealerInfoService dealerInfoService;

	/**
	 * 经销商列表
	 */
	@RequestMapping(value = "/dealer/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		return PageConst.DEALER_LIST;
	}

	/**
	 * 增加/编辑经销商
	 */
	@RequestMapping(value = "/dealer/addoredit", method = { RequestMethod.GET, RequestMethod.POST })
	public String add(Model model, HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "id", required = false) Integer dealerId) {
		if (dealerId != null) {
			DealerInfo dealerInfo = dealerInfoService.selectById(dealerId);
			model.addAttribute("id", dealerId);
			model.addAttribute("name", dealerInfo.getName());
			model.addAttribute("province", dealerInfo.getProvince());
			model.addAttribute("city", dealerInfo.getCity());
			model.addAttribute("address", dealerInfo.getAddress());
			model.addAttribute("brand", dealerInfo.getBrand());
			model.addAttribute("dmsAccount", dealerInfo.getDmsAccount());
			model.addAttribute("dmsPassword", dealerInfo.getDmsPassword());
		}
		return PageConst.DEALER_ADD;
	}

	@ResponseBody
	@RequestMapping(value = "/api/dealer/save", method = { RequestMethod.GET, RequestMethod.POST })
	public String save(Model model, HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "id", required = false) Integer dealerId,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "province", required = false) String province,
			@RequestParam(value = "province_name", required = false) String provinceName,
			@RequestParam(value = "city", required = false) String city,
			@RequestParam(value = "city_name", required = false) String cityName,
			@RequestParam(value = "address", required = false) String address,
			@RequestParam(value = "brand", required = false) String brand,
			@RequestParam(value = "dmsaccount", required = false) String dmsAccount,
			@RequestParam(value = "dmspassword", required = false) String dmsPassword) {

		DealerInfo dealerInfo = new DealerInfo();
		if (dealerId != null) {
			dealerInfo=dealerInfoService.selectById(dealerId);
		} else {
			dealerInfo.setCreateTime(new Date());
		}
		dealerInfo.setName(name);
		dealerInfo.setProvince(province);
		dealerInfo.setProvinceName(provinceName);
		dealerInfo.setCity(city);
		dealerInfo.setCityName(cityName);
		dealerInfo.setAddress(address);
		dealerInfo.setBrand(brand);
		dealerInfo.setDmsAccount(dmsAccount);
		dealerInfo.setDmsPassword(dmsPassword);
		dealerInfo.setUpdateTime(new Date());
		try {
			if (dealerId != null) {
				dealerInfoService.update(dealerInfo);
			} else {
				dealerInfoService.insert(dealerInfo);
			}
		} catch (Exception e) {
           e.printStackTrace();
           return "false";
		}
		return "success";
	}

	@ResponseBody
	@RequestMapping(value = "/api/dealer/list", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult getChannelList(@RequestParam(value = "searchcondition", required = false) String searchCondition,
			@RequestParam(value = "dealername", required = false) String name,
			@RequestParam(value = "brand", required = false) String brand,
			@RequestParam(value = "province", required = false) String province,
			@RequestParam(value = "city", required = false) String city) {
		SearchDataVo vo = SearchUtil.getVo();
		JsonResult result = new JsonResult();
		if (searchCondition != null) {
			if ("dealername".equals(searchCondition)) {
				if (name != null) {
					vo.putSearchParam("name", name, name);
				}
			} else if ("brand".equals(searchCondition)) {
				if(brand != null){
					vo.putSearchParam("brand", brand, brand);
				}				
			}else if("province-city".equals(searchCondition)){
				if (province != null) {
					vo.putSearchParam("province", province, province);
				}
				if (city != null) {
					vo.putSearchParam("city", city, city);
				}
			}
		}
		dealerInfoService.selectDealerList(vo);
		result.setTotal(vo.getCount() + "");
		result.setRows(vo.getList());
		return result;
	}

}
