package com.gionee.common.constant;


/**
 * @author dingyw
 *该类为快速搭建框架的java模板
 * 2015年11月30日
 */
public class CommonConstant {
	
	
	/**
	 * 返回码
	 */
	public enum RSP_CODE {
		SUCCESS("0000", "成功"), FAILED("0001", "失败");

		String value;
		String desc;

		RSP_CODE(String value, String desc) {
			this.value = value;
			this.desc = desc;
		}

		@Override
		public String toString() {
			return this.value;
		}

		public String getValue() {
			return this.value;
		}

		public String getDesc() {
			return this.desc;
		}
	}
	/**
	 * 系统机构编码
	 */
	public enum COMMON_SYS_CODE {
		SELF_SYS_CODE("0034", "营销平台核心"); //表示本系统

		String value;
		String desc;

		COMMON_SYS_CODE(String value, String desc) {
			this.value = value;
			this.desc = desc;
		}

		@Override
		public String toString() {
			return this.value;
		}

		public String getValue() {
			return this.value;
		}

		public String getDesc() {
			return this.desc;
		}
	}
	public enum SEQ_TYPE {
		COMMON("com", "正常的流水前缀"),
		RETURN("BAK", "返回报文序列号"),
		MID_SEQ("MID", "MQ消息ID"),
		ORDER("EOR", "内部订单");
		
		String value;
		String desc;

		SEQ_TYPE(String value, String desc) {
			this.value = value;
			this.desc = desc;
		}

		@Override
		public String toString() {
			return this.value;
		}

		public String getValue() {
			return this.value;
		}

		public String getDesc() {
			return this.desc;
		}

	}
	
	public enum TXN_LOG_STATUS {
		INIT("99", "事务初始化"), 
		FAILED("0", "事务失败"),
		SUCCESS("1", "事务成功"),
		DEALING("2", "事务处理中"),
		TASK_DEALING("3", "定时事务处理中"),
		TASK_SUCCESS("4", "定时事务成功"),
		TASK_FAILED("5", "定时事务失败");
		String value;
		String desc;

		TXN_LOG_STATUS(String value, String desc) {
			this.value = value;
			this.desc = desc;
		}

		@Override
		public String toString() {
			return this.value;
		}

		public String getValue() {
			return this.value;
		}

		public String getDesc() {
			return this.desc;
		}

	}


	public enum IsValid {
		False("0", "无效"),True("1", "有效"), Start("2", "已激活"),Stop("3","已停止");

		String value;
		String desc;

		IsValid(String value, String desc) {
			this.value = value;
			this.desc = desc;
		}

		@Override
		public String toString() {
			return this.value;
		}

		public String getValue() {
			return this.value;
		}

		public String getDesc() {
			return this.desc;
		}

		public static String getDescByValue(String value) {
			if (True.toString().equals(value)) {
				return True.desc;
			} else if(False.toString().equals(value)){
				return False.desc;
			}else if(Start.toString().equals(value)){
				return Start.desc;
			}else if(Stop.toString().equals(value)){
				return Stop.desc;
			}
			
			return False.desc;
		}
	}
	
	public enum PLATFORM_TYPE {
		//平台类型
		ONLINE("1","网游"),
		ALONE("2","单机"),
		ALL("","全部");
		
		String value;
		String desc;

		PLATFORM_TYPE(String value, String desc) {
			this.value = value;
			this.desc = desc;
		}

		@Override
		public String toString() {
			return this.value;
		}

		public String getValue() {
			return this.value;
		}

		public String getDesc() {
			return this.desc;
		}

		public static String getDescByValue(String value) {
			if (ONLINE.toString().equals(value)) {
				return ONLINE.desc;
			} else if (ALONE.toString().equals(value)) {
				return ALONE.desc;
			}else if(ALL.toString().equals(value)){
				return ALL.desc;
			}else{
				return "";
			}
		}
		
		public static String getValueByDesc(String desc) {
			if (ONLINE.desc.toString().equals(desc)) {
				return ONLINE.getValue();
			} else if (ALONE.desc.toString().equals(desc)) {
				return ALONE.getValue();
			}else if(ALL.desc.toString().equals(desc)){
				return ALL.getValue();
			}else{
				return "";
			}
		}
	}
	
	 
	
	public enum TRAN_TYPE {
		//交易类型
		RECHARGE("1","充值"),
		CONSUME("2","消费"),
		RECHARGE_CONSUME("3","充值和消费");
		
		String value;
		String desc;

		TRAN_TYPE(String value, String desc) {
			this.value = value;
			this.desc = desc;
		}

		@Override
		public String toString() {
			return this.value;
		}

		public String getValue() {
			return this.value;
		}

		public String getDesc() {
			return this.desc;
		}

		public static String getDescByValue(String value) {
			if (RECHARGE.toString().equals(value)) {
				return RECHARGE.desc;
			} else if (CONSUME.toString().equals(value)) {
				return CONSUME.desc;
			} else if (RECHARGE_CONSUME.toString().equals(value)) {
				return RECHARGE_CONSUME.desc;
			}else{
				return "";
			}
		}
		
		public static String getValueByDesc(String desc) {
			if (RECHARGE.desc.toString().equals(desc)) {
				return RECHARGE.getValue();
			} else if (CONSUME.desc.toString().equals(desc)) {
				return CONSUME.getValue();
			}else if (RECHARGE_CONSUME.desc.toString().equals(desc)) {
				return RECHARGE_CONSUME.getValue();
			}else{
				return "";
			}
		}
	}
	
	public enum SCENE {
		//适用场景
		//1：消费
		//2：首次交易
		CONSUME("1","消费"),
		FIRST_TRAN("2","首次交易"),
		RECHARGE("3","充值");
		//RECHARGE_CONSUME("4","充值和消费");
		
		String value;
		String desc;

		SCENE(String value, String desc) {
			this.value = value;
			this.desc = desc;
		}

		@Override
		public String toString() {
			return this.value;
		}

		public String getValue() {
			return this.value;
		}

		public String getDesc() {
			return this.desc;
		}

		public static String getDescByValue(String value) {
			if (CONSUME.toString().equals(value)) {
				return CONSUME.desc;
			} else if (FIRST_TRAN.toString().equals(value)) {
				return FIRST_TRAN.desc;
			} else if(RECHARGE.toString().equals(value)){
				return RECHARGE.desc;
			} else{
				return "";
			}
		}
		
		public static String getValueByDesc(String desc) {
			if (FIRST_TRAN.desc.toString().equals(desc)) {
				return FIRST_TRAN.getValue();
			} else if (CONSUME.desc.toString().equals(desc)) {
				return CONSUME.getValue();
			} else if(RECHARGE.desc.toString().equals(desc)){
				return RECHARGE.getValue();
			} else{
				return "";
			}
		}
	}
	
	public enum PAY_CHANNEL {
		//支付渠道
		//A币支付:100
		//ALIPAY:101
		//TENPAY:103
		//WECHATPAY:108
		//VOUCHER:204
		ACODE("100","A币支付"),
		ALIPAY("101","ALIPAY"),
		TENPAY("103","TENPAY"),
		WECHATPAY("108","WECHATPAY"),
		VOUCHER("204","VOUCHER");
		
		String value;
		String desc;

		PAY_CHANNEL(String value, String desc) {
			this.value = value;
			this.desc = desc;
		}

		@Override
		public String toString() {
			return this.value;
		}

		public String getValue() {
			return this.value;
		}

		public String getDesc() {
			return this.desc;
		}

		public static String getDescByValue(String value) {
			if (ACODE.toString().equals(value)) {
				return ACODE.desc;
			} else if (ALIPAY.toString().equals(value)) {
				return ALIPAY.desc;
			}  else if (TENPAY.toString().equals(value)) {
				return TENPAY.desc;
			} else if (WECHATPAY.toString().equals(value)) {
				return WECHATPAY.desc;
			} else if (VOUCHER.toString().equals(value)) {
				return VOUCHER.desc;
			}  else{
				return "";
			}
		}
		
	}
 
	/****订单状态和流水状态  0:初始化，1：准备中，2：成功，3：失败*/
	public enum ORDER_STATUS {
		//支付渠道
		//A币支付:100
		//ALIPAY:101
		//TENPAY:103
		//WECHATPAY:108
		//VOUCHER:204
		INIT("0","初始化"),
		PREPARE("1","准备中"),
		SECCESS("2","成功"),
		FAIL("3","失败");
		
		
		String value;
		String desc;

		ORDER_STATUS(String value, String desc) {
			this.value = value;
			this.desc = desc;
		}

		@Override
		public String toString() {
			return this.value;
		}

		public String getValue() {
			return this.value;
		}

		public String getDesc() {
			return this.desc;
		}

		public static String getDescByValue(String value) {
			if (INIT.toString().equals(value)) {
				return INIT.desc;
			} else if (PREPARE.toString().equals(value)) {
				return PREPARE.desc;
			}  else if (SECCESS.toString().equals(value)) {
				return SECCESS.desc;
			} else if (FAIL.toString().equals(value)) {
				return FAIL.desc;
			} else{
				return "";
			}
		}
		
	}
	
	
	/***
	 * 红包状态 0：可以被领取 1：已经被领取 2：领取失败
	 */
		public enum RED_PACK_STATUS {
			INIT("0","可以被领取"),
			SUCCESS("1","已经被领取"),
			FAIL("2","领取失败"),
			PREPARE("3","准备领取");
			
			String value;
			String desc;

			RED_PACK_STATUS(String value, String desc) {
				this.value = value;
				this.desc = desc;
			}

			@Override
			public String toString() {
				return this.value;
			}

			public String getValue() {
				return this.value;
			}

			public String getDesc() {
				return this.desc;
			}

			public static String getDescByValue(String value) {
				if (INIT.toString().equals(value)) {
					return INIT.desc;
				} else if (SUCCESS.toString().equals(value)) {
					return SUCCESS.desc;
				} else if (FAIL.toString().equals(value)) {
					return FAIL.desc;
				} else{
					return "";
				}
			}
			
		}
		

}
