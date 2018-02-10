package com.project.xxx.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.xxx.common.Common;
import com.project.xxx.core.IPublishService;
import com.project.xxx.core.models.Publish;

@Controller
public class PublishController {

	@Resource
	private IPublishService publishService;
	
	@RequestMapping("publish_query.do")
	public String queryPublish(HttpServletRequest request, Model model) {
		boolean isAuthorized = Common.objToBoolean(request.getSession().getAttribute("isAuthorized"));
		if (!isAuthorized) {
			return "redirect:login.jsp";
		}
		List list = publishService.selectAllData();
		model.addAttribute("list", list);
		return "publish";
	}
	
	@RequestMapping("publish_detail.do")
	public String queryDetail(HttpServletRequest request, Model model) {
		boolean isAuthorized = Common.objToBoolean(request.getSession().getAttribute("isAuthorized"));
		if (!isAuthorized) {
			return "redirect:login.jsp";
		}
		int id = Common.objToInteger(request.getParameter("publish_id"));
		System.out.println("publish_id:" + id);
		Publish publish = publishService.selectByPrimaryKey(id);
		model.addAttribute("publish", publish);
		return "publish_detail";
	}
}
