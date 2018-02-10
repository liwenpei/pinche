package com.gionee.pay.promotion.core.vo.models;

import com.gionee.common.vo.BaseVo;

public class PayPromotionCoreWechatRedPackageTabKey  extends BaseVo {
    private Integer package_seq_id;

    private String activity_no;

    public Integer getPackage_seq_id() {
        return package_seq_id;
    }

    public void setPackage_seq_id(Integer package_seq_id) {
        this.package_seq_id = package_seq_id;
    }

    public String getActivity_no() {
        return activity_no;
    }

    public void setActivity_no(String activity_no) {
        this.activity_no = activity_no;
    }
}