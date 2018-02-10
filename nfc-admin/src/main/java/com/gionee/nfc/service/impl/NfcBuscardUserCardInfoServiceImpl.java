/**
 * 
 */
package com.gionee.nfc.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gionee.common.exception.BizException;
import com.gionee.nfc.admin.dao.mapper.NfcBuscardUserCardInfoTbMapper;
import com.gionee.nfc.admin.vo.models.NfcBuscardUserCardInfoTb;
import com.gionee.nfc.admin.vo.models.NfcBuscardUserCardInfoTbKey;
import com.gionee.nfc.service.NfcBuscardUserCardInfoService;

/**
 * @author zhanggq
 *
 *         2017年10月19日
 */
@Service
public class NfcBuscardUserCardInfoServiceImpl implements NfcBuscardUserCardInfoService {
	@Autowired
	NfcBuscardUserCardInfoTbMapper nfcBuscardUserCardInfoTbMapper;

	@Override
	public List<NfcBuscardUserCardInfoTb> queryBusCardList(NfcBuscardUserCardInfoTb vo) throws BizException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("xTsmCplc", vo.getxTsmCplc());
		params.put("user_id", vo.getUser_id());
		params.put("phone_no", vo.getPhone_no());
		params.put("pay_type", vo.getPay_type());
		params.put("city_code", vo.getCity_code());
		params.put("create_date", vo.getCreate_date());

		String orderParam = "create_time desc";
		return nfcBuscardUserCardInfoTbMapper.selectAllListByParams(params, orderParam);
	}

	@Override
	public NfcBuscardUserCardInfoTb queryByXTsmCplcAndAid(NfcBuscardUserCardInfoTb vo) throws BizException {
		if (StringUtils.isEmpty(vo.getxTsmCplc()) || StringUtils.isEmpty(vo.getAid())) {
			throw new BizException("参数异常 ");
		}

		NfcBuscardUserCardInfoTbKey buscardKey = new NfcBuscardUserCardInfoTbKey();
		buscardKey.setAid(vo.getAid());
		buscardKey.setxTsmCplc(vo.getxTsmCplc());

		return nfcBuscardUserCardInfoTbMapper.selectByPrimaryKey(buscardKey);

	}

	@Override
	public void updateBuscardInfo(NfcBuscardUserCardInfoTb record) throws BizException {
		record.setLast_upd_time(new Date());
		nfcBuscardUserCardInfoTbMapper.updateByPrimaryKeySelective(record);
		
	}

	@Override
	public void deleteBusCardInfo(NfcBuscardUserCardInfoTb vo) throws BizException {
		NfcBuscardUserCardInfoTbKey buscardKey = new NfcBuscardUserCardInfoTbKey();
		buscardKey.setAid(vo.getAid());
		buscardKey.setxTsmCplc(vo.getxTsmCplc());
		nfcBuscardUserCardInfoTbMapper.deleteByPrimaryKey(buscardKey);
	}

}
