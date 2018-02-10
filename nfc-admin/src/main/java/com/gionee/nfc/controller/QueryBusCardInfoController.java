/**
 * 
 */
package com.gionee.nfc.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gionee.common.controller.AbsController;
import com.gionee.common.exception.BizException;
import com.gionee.nfc.action.QueryBusCardInfoAction;
import com.gionee.nfc.admin.vo.models.NfcBuscardUserCardInfoTb;

/**
 * @author zhanggq
 *
 *         2017年2月22日
 */
@Controller
public class QueryBusCardInfoController extends
		AbsController {
	Logger log = LoggerFactory.getLogger(getClass());
	private final String prefix = "/buscard_";
	private final String view_url = "/jsp/buscard/";
	@Autowired
	QueryBusCardInfoAction queryBusCardInfoAction;

	@RequestMapping(value = prefix + "query")
	public String query(HttpServletRequest req, HttpSession httpSession, NfcBuscardUserCardInfoTb vo,
			Map<String, Object> model) throws BizException {
		log.info("vo-->" + vo);
		
		List<NfcBuscardUserCardInfoTb> busCardList = queryBusCardInfoAction.queryBusCardList(vo);
		
		model.put("list", busCardList);
		model.put("vo", vo);// 将请求参数带回去
		model.put("req_url", "merchant_query");
		model.put("req_url_sub", "merchant_query");
		return view_url + "queryBuscard";
	}
	
	@RequestMapping(value = prefix + "detail")
	public String view(HttpServletRequest req, HttpSession httpSession, NfcBuscardUserCardInfoTb vo,
			Map<String, Object> model) throws BizException {
		log.info("vo-->" + vo);
		
		NfcBuscardUserCardInfoTb buscard = queryBusCardInfoAction.queryDetail(vo);
		
		model.put("result", buscard);
		model.put("vo", vo);// 将请求参数带回去
		model.put("req_url", "buscard_query");
		return view_url + "detail";
	}
	
	
	@RequestMapping(value = prefix + "editView")
	public String editView(HttpServletRequest req, HttpSession httpSession, NfcBuscardUserCardInfoTb vo,
			Map<String, Object> model) throws BizException {
		log.info("vo-->" + vo);
		
		NfcBuscardUserCardInfoTb buscard = queryBusCardInfoAction.queryDetail(vo);
		
		model.put("result", buscard);
		model.put("vo", vo);// 将请求参数带回去
		model.put("req_url", "buscard_query");
		return view_url + "editView";
	}
	
	
	@RequestMapping(value = prefix + "edit")
	public String edit(HttpServletRequest req, HttpSession httpSession, NfcBuscardUserCardInfoTb vo,
			Map<String, Object> model) throws BizException {
		log.info("vo-->" + vo);
		try{
			queryBusCardInfoAction.updateBuscardInfo(vo);
		}catch(Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(), e);
		}
		
		NfcBuscardUserCardInfoTb buscard = queryBusCardInfoAction.queryDetail(vo);
		model.put("result", buscard);
		model.put("vo", vo);// 将请求参数带回去
		model.put("req_url", "buscard_query");
		return view_url + "detail";
	}
	
	@RequestMapping(value = prefix + "delete", produces="plain/text;charset=utf-8")
	@ResponseBody
	public String deleteMerchant(HttpSession session, NfcBuscardUserCardInfoTb vo, Map<String, Object> model)
			throws BizException {
		log.info("vo-->{}", vo);

		if (StringUtils.isEmpty(vo.getxTsmCplc()) || StringUtils.isEmpty(vo.getAid())) {
			return "参数为空";
		}
		
		try{
			queryBusCardInfoAction.deleteCard(vo);
			return "0";
		}catch(Exception e) {
			log.error(e.getMessage(), e);
			return e.getMessage();
		}
	}

	

	

}
