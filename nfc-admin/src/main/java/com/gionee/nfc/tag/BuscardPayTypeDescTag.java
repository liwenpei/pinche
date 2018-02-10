/**
 * 
 */
package com.gionee.nfc.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;

import com.gionee.common.constant.CommonConstant;

/**
 * @author zhanggq
 *
 *         2016年7月5日
 */
public class BuscardPayTypeDescTag extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int doStartTag() throws JspException {
		try {
			JspWriter out = this.pageContext.getOut();

			if (value == null) {

				out.println("value not found");

				return SKIP_BODY;

			}
			// 返回是、否
			if (StringUtils.isEmpty(value)) {
				out.println("");
			} else {
				out.println(CommonConstant.BUS_CARD_PAY_TYPE.getDescByValue(value));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

}
