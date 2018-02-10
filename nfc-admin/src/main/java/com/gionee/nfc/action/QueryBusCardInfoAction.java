/**
 * 
 */
package com.gionee.nfc.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gionee.common.exception.BizException;
import com.gionee.nfc.admin.vo.models.NfcBuscardUserCardInfoTb;
import com.gionee.nfc.service.NfcBuscardUserCardInfoService;

/**
 * @author zhanggq
 *
 * 2017年10月19日
 */
@Service
public class QueryBusCardInfoAction {
	@Autowired
	NfcBuscardUserCardInfoService nfcBuscardUserCardInfoService;
	/**
	 * @param vo
	 * @return
	 * @throws BizException 
	 */
	public List<NfcBuscardUserCardInfoTb> queryBusCardList(NfcBuscardUserCardInfoTb vo) throws BizException {
		
		return nfcBuscardUserCardInfoService.queryBusCardList(vo);
	}
	/**
	 * @param vo
	 * @return
	 */
	public NfcBuscardUserCardInfoTb queryDetail(NfcBuscardUserCardInfoTb vo) throws BizException {
		
		return nfcBuscardUserCardInfoService.queryByXTsmCplcAndAid(vo);
	}
	/**
	 * @param vo
	 */
	public void updateBuscardInfo(NfcBuscardUserCardInfoTb vo) throws BizException{
		nfcBuscardUserCardInfoService.updateBuscardInfo(vo);
	}
	/**
	 * @param vo
	 */
	public void deleteCard(NfcBuscardUserCardInfoTb vo) throws BizException {
		nfcBuscardUserCardInfoService.deleteBusCardInfo(vo);
	}

}
