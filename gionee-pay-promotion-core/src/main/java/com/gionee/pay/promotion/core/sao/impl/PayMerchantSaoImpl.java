package com.gionee.pay.promotion.core.sao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gionee.pay.promotion.core.dao.mapper.PayMerchantMapper;
import com.gionee.pay.promotion.core.sao.PayMerchantSao;
import com.gionee.pay.promotion.core.vo.models.PayMerchant;

@Service
public class PayMerchantSaoImpl implements PayMerchantSao {
	@Autowired
	PayMerchantMapper payMerchantMapper;
	@Override
	public List<PayMerchant> getPayMerchantInfo(Map<String,Object> params,String order_param) {
		return payMerchantMapper.selectAllListByParams(params, order_param);	
	}
	
}
