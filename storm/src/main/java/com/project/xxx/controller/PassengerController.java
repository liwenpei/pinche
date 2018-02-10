package com.project.xxx.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.xxx.common.Common;
import com.project.xxx.core.IPassengerService;

@Controller
public class PassengerController {

	@Resource
	private IPassengerService passengerService;
	
	@RequestMapping("passenger_query.do")
	public String queryPublish(HttpServletRequest request, Model model) {
		boolean isAuthorized = Common.objToBoolean(request.getSession().getAttribute("isAuthorized"));
		if (!isAuthorized) {
			return "redirect:login.jsp";
		}
		List list = passengerService.selectAllData();
		model.addAttribute("list", list);
		return "passenger";
	}
}
