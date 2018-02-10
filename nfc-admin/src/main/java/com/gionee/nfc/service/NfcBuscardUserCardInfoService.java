/**
 * 
 */
package com.gionee.nfc.service;

import java.util.List;

import com.gionee.common.exception.BizException;
import com.gionee.nfc.admin.vo.models.NfcBuscardUserCardInfoTb;

/**
 * @author zhanggq
 *
 * 2017年10月19日
 */
public interface NfcBuscardUserCardInfoService {

	/**
	 * @param vo
	 * @return
	 */
	List<NfcBuscardUserCardInfoTb> queryBusCardList(NfcBuscardUserCardInfoTb vo) throws BizException;

	/**
	 * @param vo
	 * @return
	 */
	NfcBuscardUserCardInfoTb queryByXTsmCplcAndAid(NfcBuscardUserCardInfoTb vo) throws BizException;

	/**
	 * @param vo
	 */
	void updateBuscardInfo(NfcBuscardUserCardInfoTb vo) throws BizException;

	/**
	 * @param vo
	 */
	void deleteBusCardInfo(NfcBuscardUserCardInfoTb vo) throws BizException;

}
