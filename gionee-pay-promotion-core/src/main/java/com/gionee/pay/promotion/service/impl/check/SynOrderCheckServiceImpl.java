package com.gionee.pay.promotion.service.impl.check;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gionee.common.exception.BizException;
import com.gionee.common.msg.ReqMsgVo;
import com.gionee.pay.promotion.core.vo.SynOrderVo;
import com.gionee.pay.promotion.core.vo.req.ReqSynOrderVo;
import com.gionee.pay.promotion.service.security.SecurityFacade;
import com.gionee.pay.promotion.service.synOrder.check.SynOrderCheckService;

/**
 * @author liwenpei
 *
 * 2016年09月02日
 */
@Service
public class SynOrderCheckServiceImpl implements SynOrderCheckService{
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	/**
	 * 安全服务层
	 */
	@Autowired
	SecurityFacade securityFacade;

	@Override
	public void checkSign(ReqMsgVo reqMsg) throws BizException {
		SynOrderVo vo = (SynOrderVo)reqMsg.getBody();
		
		ReqSynOrderVo reqVo=new ReqSynOrderVo();
		try {
			BeanUtils.copyProperties(reqVo, vo);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sign=securityFacade.getSign(reqVo);
		if(StringUtils.isEmpty(sign)){
			throw new BizException("签名为空");
		}
		if(null==reqMsg.getHeader().getSign()){
			throw new BizException("请求签名为空");
		}
		if(!sign.equals(reqMsg.getHeader().getSign())){
			throw new BizException("签名验证失败");
		}
		
	}

}
