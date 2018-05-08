package com.new4s.weibao.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.new4s.weibao.common.web.PageConst;
import com.new4s.weibao.web.BasicController;

/**
 * 首页Controller
 */
@Controller
public class IndexController extends BasicController {

	/**
	 * 首页
	 * 
	 * @param model
	 * @param tag
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	@RequestMapping(value = "/index", method = { RequestMethod.GET, RequestMethod.POST })
	public String index(Model model) {
		return PageConst.INDEX_PAGE;
	}

	@RequestMapping("/index/topwd")
	public String topwd(Model model) {
		return PageConst.INDEX_PASSWD;
	}

	/**
	 * 修改密码
	 * 
	 * @param model
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/index/updatepwd", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Model updatepwd(Model model, HttpServletRequest req) {
		return model;
	}

	@RequestMapping(value = "/index/report", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Model getIndexReportAjaxSearch(Model model,
			@RequestParam(value = "startDate", required = false) String startDate,
			@RequestParam(value = "endDate", required = false) String endDate) {

		return model;
	}
}
