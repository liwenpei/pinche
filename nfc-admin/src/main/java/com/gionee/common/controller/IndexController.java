package com.gionee.common.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * index的Controller
 * 
 * @author dingyw
 *
 *         2015年7月24日
 */
@Controller
public class IndexController {
	Logger log = LoggerFactory.getLogger(getClass());


	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request, 
			Map<String, Object> model) {

		model.put("req_url", "index");
		return "index";

	}

}
