package com.gionee.common.constant;

/**
 * @author dingyw 该类为快速搭建框架的java模板 2015年11月30日
 */
public class CommonConstant {

	/**
	 * 返回码
	 */
	public enum RSP_CODE {
		SUCCESS("0000", "成功"), FAILED("0001", "失败"), REPEATE_CARD("0002", "重复卡"), NO_SHIFT_OUT_CARD("0003",
				"不存在迁出卡");

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
		SELF_SYS_CODE("0001", "手机钱包客户端"), UNION_PAY("1000", "银联");

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
		COMMON("com", "正常的流水前缀"), RETURN("BAK", "返回报文序列号"), MID_SEQ("MID", "MQ消息ID");

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
		INIT("99", "事务初始化"), FAILED("0", "事务失败"), SUCCESS("1", "事务成功"), DEALING("2", "事务处理中");

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

	public enum NFC_UNION_CARD_STATUS {
		INITIAL("INITIAL", "初始化"), ACTIVE("ACTIVE", "激活"), DELETED("DELETED", "注销"), SUSPENDED("SUSPENDED",
				"挂失");
		private String value;
		private String desc;

		NFC_UNION_CARD_STATUS(String value, String desc) {
			this.value = value;
			this.desc = desc;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}
	}

	public enum UNION_DELETE_CARD_RESULT_CODE {
		SUCCESS("0000", "删除成功");

		private String value;
		private String desc;

		UNION_DELETE_CARD_RESULT_CODE(String value, String desc) {
			this.value = value;
			this.desc = desc;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}
	}

	public enum IS_VALID {
		TRUE("1", "有效"), FALSE("0", "无效");

		private String value;
		private String desc;

		IS_VALID(String value, String desc) {
			this.value = value;
			this.desc = desc;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}
	}

	/**
	 * pay_type:1 开卡 2 圈存 3 开卡圈存 4 迁出卡 5 迁入卡 6 迁卡充值
	 * 
	 * @author zhanggq
	 *
	 *         2017年7月27日
	 */
	public enum BUS_CARD_PAY_TYPE {
		OPEN_CARD("1", "开卡"), CIRCLE("2", "圈存"), OPEN_CARD_CIRCLE("3", "开卡圈存"), SHIFT_OUT_CARD("4", "迁出卡"), SHIFT_IN_CARD(
				"5", "迁入卡"), SHIFT_CARD_RECHARGE("6", "迁卡充值"), WAIT_DELETE_CARD("7", "待删除"), DELETE_SUCCESS_CARD(
				"8", "删除成功");

		private String value;
		private String desc;

		BUS_CARD_PAY_TYPE(String value, String desc) {
			this.value = value;
			this.desc = desc;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}

		/**
		 * @param value2
		 * @return
		 */
		public static String getDescByValue(String value) {
			BUS_CARD_PAY_TYPE[] payTypes = BUS_CARD_PAY_TYPE.values();
			for (BUS_CARD_PAY_TYPE payType : payTypes) {
				if (payType.getValue().equals(value)) {
					return payType.getDesc();
				}
			}

			return null;
		}
	}

	public enum UNION_PAY_NOTIFY_RSP_CODE {
		SUCCESS("0000", "成功且无后继"), SYSTEM_ERROR("4102", "系统错误");

		String value;
		String desc;

		UNION_PAY_NOTIFY_RSP_CODE(String value, String desc) {
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
	public enum BUS_CARD_CITY_CODE {
		LINNAN_TONG("00", "邻南通"), SHENZHEN_TONG("2", "深圳通");

		String value;
		String desc;

		BUS_CARD_CITY_CODE(String value, String desc) {
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
			BUS_CARD_CITY_CODE[] cityCodes = BUS_CARD_CITY_CODE.values();
			for(BUS_CARD_CITY_CODE cityCode: cityCodes) {
				if(cityCode.getValue().equalsIgnoreCase(value)) {
					return cityCode.getDesc();
				}
			}
			
			return null;
		}
	}
}
