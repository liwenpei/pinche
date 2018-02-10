package com.gionee.nfc.tag.select;

import javax.servlet.jsp.JspException;

import org.springframework.util.StringUtils;

import com.gionee.nfc.tag.CommonTag;

/**
 * @author dingyw
 *
 * 2015年7月13日
 */
public class CommonSelectOptionTag extends CommonTag {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3251354190343853381L;

	protected String id;

	/**
	 * 指定的css class名
	 */
	protected String className;
	
	/**
	 * 显示**/
	protected String disabled = "false";

	/**
	 * 是否显示全部
	 */
	protected String all;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getAll() {
		return all;
	}

	public void setAll(String all) {
		this.all = all;
	}
	
	

	public String getDisabled() {
		return disabled;
	}

	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	/**显示全部或""
	 * 
	 * 在查询条件时，显示“全部”，在详细里面，显示空字符串
	 * @return
	 * @throws JspException
	 */
	public String getOptionByAll() throws JspException{
		String content=null;
			if("true".equals(all)){
				content=this.getOption("", "全部");	
			}else if("false".equals(all)){
				content=this.getOption("", "请选择");	
			}
		
		return content;
	}
	public String getOption(String itemValue, String desc) throws JspException {
		String content=null;
		try {
			
			if (!StringUtils.isEmpty(value) && itemValue.equals(value)) {
				content = "<option selected=\"selected\" value=\""
						+ itemValue + "\">"
						+ desc
						+ "</option>";
			} else {
				content = "<option value=\"" 
						+ itemValue + "\">"
						+ desc
						+ "</option>";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return content;
	}
	public String getHeadContent(){
		String str = "<select name=\""+id+"\" id=\""+id+"\" class=\""+className+"\" disabled >";
		if("true".equals(disabled)){
			str = str.replace("disabled", disabled);
		}else{
			str = str.replace("disabled", "");
		}
		return str;
	}
	public String getHeadMultiSelectContent(){
		String str = "<select name=\""+id+"\" id=\""+id+"\" multiple=\"multiple\" class=\""+className+"\" disabled >";
		if("true".equals(disabled)){
			str = str.replace("disabled", disabled);
		}else{
			str = str.replace("disabled", "");
		}
		return str;
	}
	public String getTailContent(){
		return "</select>";
	}

}
