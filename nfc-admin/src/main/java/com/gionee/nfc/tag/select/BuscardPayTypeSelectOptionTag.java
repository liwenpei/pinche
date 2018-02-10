package com.gionee.nfc.tag.select;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import com.gionee.common.constant.CommonConstant;

/**
 * @author dingyw
 *
 * 2015年7月13日
 */
public class BuscardPayTypeSelectOptionTag extends CommonSelectOptionTag {

	private static final long serialVersionUID = 1L;

	@Override
	public int doStartTag() throws JspException {
		try {
			JspWriter out = this.pageContext.getOut();

			if (id == null) {

				out.println("id not found");

				return SKIP_BODY;

			}
			/*
			 * 拼接<select name="" id=""> <option value="">aaa </option> </select>
			 */
			String content;

			content = this.getHeadContent();
			out.println(content);

			content=this.getOptionByAll();
			if(content!=null){
				out.println(content);
			}
			
			for (CommonConstant.BUS_CARD_PAY_TYPE item : CommonConstant.BUS_CARD_PAY_TYPE.values()) {
				content=this.getOption(item.getValue(), CommonConstant.BUS_CARD_PAY_TYPE.getDescByValue(item.getValue()));
				if(content!=null)
					out.println(content);
			}
			out.println(this.getTailContent());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return SKIP_BODY;

	}

}
