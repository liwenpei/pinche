package com.gionee.nfc.admin.dao.mapper;

import com.gionee.common.mapper.IBaseMapper;
import com.gionee.nfc.admin.vo.models.NfcBuscardUserCardInfoTb;
import com.gionee.nfc.admin.vo.models.NfcBuscardUserCardInfoTbKey;

public interface NfcBuscardUserCardInfoTbMapper extends IBaseMapper<NfcBuscardUserCardInfoTb>{
    int deleteByPrimaryKey(NfcBuscardUserCardInfoTbKey key);

    int insert(NfcBuscardUserCardInfoTb record);

    int insertSelective(NfcBuscardUserCardInfoTb record);

    NfcBuscardUserCardInfoTb selectByPrimaryKey(NfcBuscardUserCardInfoTbKey key);

    int updateByPrimaryKeySelective(NfcBuscardUserCardInfoTb record);

    int updateByPrimaryKey(NfcBuscardUserCardInfoTb record);
}