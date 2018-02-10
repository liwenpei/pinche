package com.gionee.pay.promotion.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.gionee.pay.promotion.service.synOrder.check.CommomServiceCheckFacade;

/**
 * @author liwenpei
 * 
 *         2016年08月31日
 */
public abstract class AbsBaseAction<T> implements IBaseAction<T> {
	Logger log = LoggerFactory.getLogger(getClass());
 

	/**
	 * 公共校验类
	 */
	@Autowired
	protected CommomServiceCheckFacade commomServiceCheckFacade;
 
 
 
}
