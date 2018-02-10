package com.gionee.common.mq;

import javax.jms.Message;
import javax.jms.TextMessage;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.gionee.common.action.IBaseAction;
import com.gionee.common.constant.CommonConstant;
import com.gionee.common.exception.BizException;
import com.gionee.common.exception.NotRollBackBizException;
import com.gionee.common.mq.AbsRiskListener;
import com.gionee.common.utils.MsgUtils;
import com.gionee.common.vo.BaseMsgVo;

/**
 * 接受MQ请求的总入口
 * @author dingyw
 *
 * 2015年12月4日
 */
@Component("facadeCommonListener")
public class FacadeCommonListener extends AbsRiskListener{
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	@Override
	public void onMessage(Message message) {

		TextMessage req=(TextMessage)message;
		
		log.info("enter FacadeCommonListener~~~~");

		try {
			JSONObject jsonReq=MsgUtils.getJSONObject(req.getText());//从request获取json
			
			String transCode = this.getTransCode(jsonReq);//获取交易码

			IBaseAction<BaseMsgVo> action = transactionMapService
					.getActionByMap(transCode);// 根据容器的配置信息,根据交易码找到对应的处理action
			
			if(null==action){
				throw new BizException(CommonConstant.RSP_CODE.FAILED.getValue(),"交易码错误");
			}
			BaseMsgVo msg = (BaseMsgVo) action.getMsg(jsonReq);// 根据容器的配置信息，调用不同的action进行服务	
			
			BaseMsgVo result=action.execute(msg);
			
			 //将正常结果通过resp返回json对象 
			log.info("resultvo->"+result);
			
			this.printJsonResponse(message, result);
			
		}catch(NotRollBackBizException e){
			e.printStackTrace();
			log.error(e.getMessage(),e); 
			this.printJsonResponse(message, e);
		}catch(BizException e){
			e.printStackTrace();
			log.error(e.getMessage(),e); 
			this.printJsonResponse(message, e);
		}catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(),e); 
			this.printJsonResponse(message, e);
		}
	}

}
