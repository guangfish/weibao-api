package com.new4s.weibao.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.new4s.weibao.common.web.PageConst;
import com.new4s.weibao.web.BasicController;

/**
 * OpenApi Controller
 */
@Controller
public class OpenApiController extends BasicController {

	/**
	 * OpenAPI列表
	 */
	@RequestMapping(value = "/openapi/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		return PageConst.API_LIST;
	}

}
