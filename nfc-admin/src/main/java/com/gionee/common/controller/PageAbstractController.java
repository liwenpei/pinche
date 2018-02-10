package com.gionee.common.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.minidev.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.gionee.common.exception.BizException;

public abstract class PageAbstractController<V,U>  extends AbsController {
	Logger log = LoggerFactory.getLogger(getClass());
	public String ajax_get_data(HttpServletRequest req, HttpSession httpSession,
			V vo, Map<String, Object> model) throws BizException {
		try{
			vo = buildSearchQueryVo(req);
			int start = Integer
					.parseInt(req.getParameter("iDisplayStart") == null ? "0" : req
							.getParameter("iDisplayStart"));
			int page_size = Integer
					.parseInt(req.getParameter("iDisplayLength") == null ? "0"
							: req.getParameter("iDisplayLength"));
			String sEcho = req.getParameter("sEcho");
			
			List<U> pageList = queryPageList(vo, start, page_size);
			
			int totalCount = queryTotalCount(vo);

			JSONObject json = composeResponseJson(sEcho, page_size, totalCount, pageList);

			return json.toString();
		}catch(BizException e) {
			log.error(e.getRsp_desc(), e);
			throw e;
		}catch(Exception e) {
			log.error(e.getMessage(), e);
			throw new BizException(e.getMessage());
		}
		
	}
	
	public abstract V buildSearchQueryVo(HttpServletRequest req) throws BizException;
	
	public abstract List<U> queryPageList(V v, int start, int page_size) throws BizException;
	
	public abstract int queryTotalCount(V v) throws BizException;
	
	
	private JSONObject composeResponseJson(String sEcho, int page_size, int total_count, List<U> pageList) throws BizException {
		JSONObject json = new JSONObject();
		json.put("sEcho", sEcho);
		json.put("iTotalRecords", total_count);
		json.put("iTotalDisplayRecords", total_count);
		json.put("iDisplayLength", page_size);
		
		JSONArray data = composePageListJsonData(pageList);
		json.put("aaData", data);
		return json;
	}

	public abstract JSONArray composePageListJsonData(List<U> pageList) throws BizException;
	
	public String getNotNull(String param) {
		if(StringUtils.isEmpty(param)) {
			return "";
		}
		
		return param;
	}
	
	public String getNotNullString(String s) {
		return StringUtils.hasText(s) ? s : "";
	}

	public String getNotNullBigDecimal(BigDecimal b) {
		if (b == null) {
			return "";
		}

		return b.toString();
	}

	public String getNotNullPerchantBigDecimal(BigDecimal decimal_param) {
		if (decimal_param == null) {
			return "";
		}
		return decimal_param.multiply(new BigDecimal("100")).setScale(2, RoundingMode.HALF_UP) + "%";
	}
}
