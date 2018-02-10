package com.gionee.common.mq;

import javax.jms.MessageListener;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.gionee.common.constant.CommonConstant;
import com.gionee.common.exception.BizException;
import com.gionee.common.transactionMap.TransactionMapService;


public abstract class AbsCommonRiskListener implements MessageListener{
	
	Logger log = LoggerFactory.getLogger(getClass());
	/**
	 * transactionMapService业务层逻辑,根据交易码寻找对应的Controller处理
	 */
	@Autowired
	protected TransactionMapService transactionMapService;
	/**
	 * 将json对象转化为javabean，然后获取交易码
	 * 
	 * @param json
	 * @return
	 * @throws Exception
	 */
	public String getTransCode(JSONObject json) throws Exception {

		String trans_code = json.getString("trans_code");
		if (null == trans_code) {
			throw new BizException(CommonConstant.RSP_CODE.FAILED.getValue(),
					"交易码没有设置");
		}
		return trans_code;
	}
}
