package com.gionee.nfc.admin.dao.mapper;

import com.gionee.nfc.admin.vo.models.NfcUnionCardInfoTb;

public interface NfcUnionCardInfoTbMapper {
    int deleteByPrimaryKey(String virtualCardRefId);

    int insert(NfcUnionCardInfoTb record);

    int insertSelective(NfcUnionCardInfoTb record);

    NfcUnionCardInfoTb selectByPrimaryKey(String virtualCardRefId);

    int updateByPrimaryKeySelective(NfcUnionCardInfoTb record);

    int updateByPrimaryKey(NfcUnionCardInfoTb record);
}