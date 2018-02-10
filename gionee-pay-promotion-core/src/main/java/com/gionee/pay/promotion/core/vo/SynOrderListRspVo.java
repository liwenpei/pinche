package com.gionee.pay.promotion.core.vo;

import java.util.List;

import com.gionee.common.vo.BaseVo;

public class SynOrderListRspVo extends BaseVo{

	private String total;
	private List<SynOrderRspVo> list;
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public List<SynOrderRspVo> getList() {
		return list;
	}
	public void setList(List<SynOrderRspVo> list) {
		this.list = list;
	}
	
	
	
}
