package com.gionee.pay.promotion.core.vo.models;

import java.math.BigDecimal;
import java.util.Date;

import com.gionee.common.vo.BaseVo;

public class PayPromotionCoreTxnLogTab  extends BaseVo {
    private Integer id;

    private String int_txn_no;

    private String int_trade_no;

    private Date int_txn_date;

    private Date int_txn_time;

    private String int_order_no;

    private Date int_order_date;

    private String int_order_status;

    private Date int_order_time;

    private String order_no;

    private String tradeNo;

    private String thirdTransactionNo;

    private String pay_channel;

    private BigDecimal amount;

    private String app_id;

    private String merchant_id;

    private BigDecimal gift_trans_amt;

    private String outOrderNo;

    private String trans_type;

    private String user_id;

    private String wechat_open_id;

    private Date pay_create_time;

    private Date pay_trans_time;

    private String platform_type;

    private String busi_type;

    private String package_seq_id;

    private String activity_no;

    private String activity_name;

    private String activity_app_id;

    private String activity_status;

    private String activity_desc;

    private String share_statement;

    private String share_desc;

    private String share_pic_url;

    private String share_url;

    private String sponsor;

    private String wish_des;

    private BigDecimal budget;

    private Integer quantity;

    private Integer limited_quantity;

    private String scene;

    private String rule_type;

    private String rule_param;

    private Date effc_time;

    private Date expired_time;

    private String gift_type;

    private String service_type;

    private String status;

    private String trade_status;

    private String pack_status;

    private String nonce_str;

    private String sign;

    private String mch_billno;

    private String client_ip;

    private String remark;

    private String send_listid;

    private String return_code;

    private String return_msg;

    private String result_code;

    private String err_code;

    private String err_code_des;

    private String imei;

    private String ua;

    private String device_model;

    private String fail_reason;

    private String req_version;

    private String req_sys_code;

    private Date req_trans_date;

    private Date req_trans_time;

    private String req_trans_code;

    private String req_trans_id;

    private String req_channel;

    private String req_trans_back_id;

    private Date req_trans_back_date;

    private String req_platform_type;

    private Date req_trans_back_time;

    private String rcv_sys_code;

    private String rcv_trans_id;

    private Date rcv_trans_date;

    private Date rcv_trans_time;

    private String rcv_rsp_code;

    private String rcv_rsp_desc;

    private Date create_date;

    private Date last_upd_time;

    private String operator;

    private String auditor;

    private String reserved1;

    private String reserved2;

    private String reserved3;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInt_txn_no() {
        return int_txn_no;
    }

    public void setInt_txn_no(String int_txn_no) {
        this.int_txn_no = int_txn_no;
    }

    public String getInt_trade_no() {
        return int_trade_no;
    }

    public void setInt_trade_no(String int_trade_no) {
        this.int_trade_no = int_trade_no;
    }

    public Date getInt_txn_date() {
        return int_txn_date;
    }

    public void setInt_txn_date(Date int_txn_date) {
        this.int_txn_date = int_txn_date;
    }

    public Date getInt_txn_time() {
        return int_txn_time;
    }

    public void setInt_txn_time(Date int_txn_time) {
        this.int_txn_time = int_txn_time;
    }

    public String getInt_order_no() {
        return int_order_no;
    }

    public void setInt_order_no(String int_order_no) {
        this.int_order_no = int_order_no;
    }

    public Date getInt_order_date() {
        return int_order_date;
    }

    public void setInt_order_date(Date int_order_date) {
        this.int_order_date = int_order_date;
    }

    public String getInt_order_status() {
        return int_order_status;
    }

    public void setInt_order_status(String int_order_status) {
        this.int_order_status = int_order_status;
    }

    public Date getInt_order_time() {
        return int_order_time;
    }

    public void setInt_order_time(Date int_order_time) {
        this.int_order_time = int_order_time;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getThirdTransactionNo() {
        return thirdTransactionNo;
    }

    public void setThirdTransactionNo(String thirdTransactionNo) {
        this.thirdTransactionNo = thirdTransactionNo;
    }

    public String getPay_channel() {
        return pay_channel;
    }

    public void setPay_channel(String pay_channel) {
        this.pay_channel = pay_channel;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(String merchant_id) {
        this.merchant_id = merchant_id;
    }

    public BigDecimal getGift_trans_amt() {
        return gift_trans_amt;
    }

    public void setGift_trans_amt(BigDecimal gift_trans_amt) {
        this.gift_trans_amt = gift_trans_amt;
    }

    public String getOutOrderNo() {
        return outOrderNo;
    }

    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
    }

    public String getTrans_type() {
        return trans_type;
    }

    public void setTrans_type(String trans_type) {
        this.trans_type = trans_type;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getWechat_open_id() {
        return wechat_open_id;
    }

    public void setWechat_open_id(String wechat_open_id) {
        this.wechat_open_id = wechat_open_id;
    }

    public Date getPay_create_time() {
        return pay_create_time;
    }

    public void setPay_create_time(Date pay_create_time) {
        this.pay_create_time = pay_create_time;
    }

    public Date getPay_trans_time() {
        return pay_trans_time;
    }

    public void setPay_trans_time(Date pay_trans_time) {
        this.pay_trans_time = pay_trans_time;
    }

    public String getPlatform_type() {
        return platform_type;
    }

    public void setPlatform_type(String platform_type) {
        this.platform_type = platform_type;
    }

    public String getBusi_type() {
        return busi_type;
    }

    public void setBusi_type(String busi_type) {
        this.busi_type = busi_type;
    }

    public String getPackage_seq_id() {
        return package_seq_id;
    }

    public void setPackage_seq_id(String package_seq_id) {
        this.package_seq_id = package_seq_id;
    }

    public String getActivity_no() {
        return activity_no;
    }

    public void setActivity_no(String activity_no) {
        this.activity_no = activity_no;
    }

    public String getActivity_name() {
        return activity_name;
    }

    public void setActivity_name(String activity_name) {
        this.activity_name = activity_name;
    }

    public String getActivity_app_id() {
        return activity_app_id;
    }

    public void setActivity_app_id(String activity_app_id) {
        this.activity_app_id = activity_app_id;
    }

    public String getActivity_status() {
        return activity_status;
    }

    public void setActivity_status(String activity_status) {
        this.activity_status = activity_status;
    }

    public String getActivity_desc() {
        return activity_desc;
    }

    public void setActivity_desc(String activity_desc) {
        this.activity_desc = activity_desc;
    }

    public String getShare_statement() {
        return share_statement;
    }

    public void setShare_statement(String share_statement) {
        this.share_statement = share_statement;
    }

    public String getShare_desc() {
        return share_desc;
    }

    public void setShare_desc(String share_desc) {
        this.share_desc = share_desc;
    }

    public String getShare_pic_url() {
        return share_pic_url;
    }

    public void setShare_pic_url(String share_pic_url) {
        this.share_pic_url = share_pic_url;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public String getWish_des() {
        return wish_des;
    }

    public void setWish_des(String wish_des) {
        this.wish_des = wish_des;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getLimited_quantity() {
        return limited_quantity;
    }

    public void setLimited_quantity(Integer limited_quantity) {
        this.limited_quantity = limited_quantity;
    }

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    public String getRule_type() {
        return rule_type;
    }

    public void setRule_type(String rule_type) {
        this.rule_type = rule_type;
    }

    public String getRule_param() {
        return rule_param;
    }

    public void setRule_param(String rule_param) {
        this.rule_param = rule_param;
    }

    public Date getEffc_time() {
        return effc_time;
    }

    public void setEffc_time(Date effc_time) {
        this.effc_time = effc_time;
    }

    public Date getExpired_time() {
        return expired_time;
    }

    public void setExpired_time(Date expired_time) {
        this.expired_time = expired_time;
    }

    public String getGift_type() {
        return gift_type;
    }

    public void setGift_type(String gift_type) {
        this.gift_type = gift_type;
    }

    public String getService_type() {
        return service_type;
    }

    public void setService_type(String service_type) {
        this.service_type = service_type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTrade_status() {
        return trade_status;
    }

    public void setTrade_status(String trade_status) {
        this.trade_status = trade_status;
    }

    public String getPack_status() {
        return pack_status;
    }

    public void setPack_status(String pack_status) {
        this.pack_status = pack_status;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getMch_billno() {
        return mch_billno;
    }

    public void setMch_billno(String mch_billno) {
        this.mch_billno = mch_billno;
    }

    public String getClient_ip() {
        return client_ip;
    }

    public void setClient_ip(String client_ip) {
        this.client_ip = client_ip;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSend_listid() {
        return send_listid;
    }

    public void setSend_listid(String send_listid) {
        this.send_listid = send_listid;
    }

    public String getReturn_code() {
        return return_code;
    }

    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public void setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
    }

    public String getResult_code() {
        return result_code;
    }

    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }

    public String getErr_code() {
        return err_code;
    }

    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }

    public String getErr_code_des() {
        return err_code_des;
    }

    public void setErr_code_des(String err_code_des) {
        this.err_code_des = err_code_des;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getUa() {
        return ua;
    }

    public void setUa(String ua) {
        this.ua = ua;
    }

    public String getDevice_model() {
        return device_model;
    }

    public void setDevice_model(String device_model) {
        this.device_model = device_model;
    }

    public String getFail_reason() {
        return fail_reason;
    }

    public void setFail_reason(String fail_reason) {
        this.fail_reason = fail_reason;
    }

    public String getReq_version() {
        return req_version;
    }

    public void setReq_version(String req_version) {
        this.req_version = req_version;
    }

    public String getReq_sys_code() {
        return req_sys_code;
    }

    public void setReq_sys_code(String req_sys_code) {
        this.req_sys_code = req_sys_code;
    }

    public Date getReq_trans_date() {
        return req_trans_date;
    }

    public void setReq_trans_date(Date req_trans_date) {
        this.req_trans_date = req_trans_date;
    }

    public Date getReq_trans_time() {
        return req_trans_time;
    }

    public void setReq_trans_time(Date req_trans_time) {
        this.req_trans_time = req_trans_time;
    }

    public String getReq_trans_code() {
        return req_trans_code;
    }

    public void setReq_trans_code(String req_trans_code) {
        this.req_trans_code = req_trans_code;
    }

    public String getReq_trans_id() {
        return req_trans_id;
    }

    public void setReq_trans_id(String req_trans_id) {
        this.req_trans_id = req_trans_id;
    }

    public String getReq_channel() {
        return req_channel;
    }

    public void setReq_channel(String req_channel) {
        this.req_channel = req_channel;
    }

    public String getReq_trans_back_id() {
        return req_trans_back_id;
    }

    public void setReq_trans_back_id(String req_trans_back_id) {
        this.req_trans_back_id = req_trans_back_id;
    }

    public Date getReq_trans_back_date() {
        return req_trans_back_date;
    }

    public void setReq_trans_back_date(Date req_trans_back_date) {
        this.req_trans_back_date = req_trans_back_date;
    }

    public String getReq_platform_type() {
        return req_platform_type;
    }

    public void setReq_platform_type(String req_platform_type) {
        this.req_platform_type = req_platform_type;
    }

    public Date getReq_trans_back_time() {
        return req_trans_back_time;
    }

    public void setReq_trans_back_time(Date req_trans_back_time) {
        this.req_trans_back_time = req_trans_back_time;
    }

    public String getRcv_sys_code() {
        return rcv_sys_code;
    }

    public void setRcv_sys_code(String rcv_sys_code) {
        this.rcv_sys_code = rcv_sys_code;
    }

    public String getRcv_trans_id() {
        return rcv_trans_id;
    }

    public void setRcv_trans_id(String rcv_trans_id) {
        this.rcv_trans_id = rcv_trans_id;
    }

    public Date getRcv_trans_date() {
        return rcv_trans_date;
    }

    public void setRcv_trans_date(Date rcv_trans_date) {
        this.rcv_trans_date = rcv_trans_date;
    }

    public Date getRcv_trans_time() {
        return rcv_trans_time;
    }

    public void setRcv_trans_time(Date rcv_trans_time) {
        this.rcv_trans_time = rcv_trans_time;
    }

    public String getRcv_rsp_code() {
        return rcv_rsp_code;
    }

    public void setRcv_rsp_code(String rcv_rsp_code) {
        this.rcv_rsp_code = rcv_rsp_code;
    }

    public String getRcv_rsp_desc() {
        return rcv_rsp_desc;
    }

    public void setRcv_rsp_desc(String rcv_rsp_desc) {
        this.rcv_rsp_desc = rcv_rsp_desc;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getLast_upd_time() {
        return last_upd_time;
    }

    public void setLast_upd_time(Date last_upd_time) {
        this.last_upd_time = last_upd_time;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public String getReserved1() {
        return reserved1;
    }

    public void setReserved1(String reserved1) {
        this.reserved1 = reserved1;
    }

    public String getReserved2() {
        return reserved2;
    }

    public void setReserved2(String reserved2) {
        this.reserved2 = reserved2;
    }

    public String getReserved3() {
        return reserved3;
    }

    public void setReserved3(String reserved3) {
        this.reserved3 = reserved3;
    }
}