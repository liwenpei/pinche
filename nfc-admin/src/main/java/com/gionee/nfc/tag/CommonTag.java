package com.gionee.nfc.tag;

import javax.servlet.ServletContext;
import javax.servlet.jsp.tagext.TagSupport;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * @author dingyw
 *
 * 2015年7月13日
 */
public class CommonTag  extends TagSupport{
	
	private static final long serialVersionUID = 1L;
	
	protected String value;

	/**
	 *获取spring的服务 
	 */
	public Object getService(String service_name) {
		ServletContext servletContext = this.pageContext.getServletContext();
		WebApplicationContext wac = WebApplicationContextUtils
				.getRequiredWebApplicationContext(servletContext);
		return wac.getBean(service_name);
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

}
