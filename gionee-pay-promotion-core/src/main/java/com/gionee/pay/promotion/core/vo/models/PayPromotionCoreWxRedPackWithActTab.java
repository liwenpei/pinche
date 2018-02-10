package com.gionee.pay.promotion.core.vo.models;

import java.math.BigDecimal;
import java.util.Date;

import com.gionee.common.vo.BaseVo;

public class PayPromotionCoreWxRedPackWithActTab  extends BaseVo {
	
	private String p_activity_no;
	private String p_package_seq_id;
	private String p_activity_name;

    private BigDecimal p_amt;

    private String p_status;

    private String p_user_id;

    private String p_wechat_open_id;

    private Date p_received_time;

    private Date p_create_date;

    private Date p_create_time;

    private Date p_last_upd_time;
    
    private String p_int_order_no;
    
    private String p_int_txn_no;
    
    private String p_req_order_no;
    
    private String p_int_trade_no;

    private String p_old_statues;

	

	private String a_activity_no;

    private String a_gift_type;

    private String a_service_type;

    private String a_pay_channel;

    private String a_is_fixed_amt;

    private String a_activity_name;

    private String a_status;

    private String a_sponsor;

    private BigDecimal a_budget;

    private Integer a_quantity;

    private Integer a_limited_quantity;

    private String a_platform_type;

    private String a_app_id;

    private String a_scene;

    private String a_rule_type;

    private String a_rule_param;

    private String a_logo_url;

    private String a_wish_desc;
    
    private String a_share_desc;

    private String a_share_statement;

    private String a_share_pic_url;

    private String a_share_url;
    
    private Date a_effc_time;
    private Date a_expired_time;

    private Date a_ceate_date;

    private Date a_create_time;

    private Date a_last_upd_time;

    private String a_operator;

    private String a_auditor;

    
    private String a_min_status;//作为判断sql的标准,不操作数据库
    private String a_max_status;//作为判断sql的标准,不操作数据库
    
    private String a_activity_desc;
    
    private String a_mark;
    
    
	public String getP_activity_no() {
		return p_activity_no;
	}

	public void setP_activity_no(String p_activity_no) {
		this.p_activity_no = p_activity_no;
	}

	public String getP_package_seq_id() {
		return p_package_seq_id;
	}

	public void setP_package_seq_id(String p_package_seq_id) {
		this.p_package_seq_id = p_package_seq_id;
	}

	public String getP_activity_name() {
		return p_activity_name;
	}

	public void setP_activity_name(String p_activity_name) {
		this.p_activity_name = p_activity_name;
	}

	public BigDecimal getP_amt() {
		return p_amt;
	}

	public void setP_amt(BigDecimal p_amt) {
		this.p_amt = p_amt;
	}

	public String getP_status() {
		return p_status;
	}

	public void setP_status(String p_status) {
		this.p_status = p_status;
	}

	public String getP_user_id() {
		return p_user_id;
	}

	public void setP_user_id(String p_user_id) {
		this.p_user_id = p_user_id;
	}

	public String getP_wechat_open_id() {
		return p_wechat_open_id;
	}

	public void setP_wechat_open_id(String p_wechat_open_id) {
		this.p_wechat_open_id = p_wechat_open_id;
	}

	public Date getP_received_time() {
		return p_received_time;
	}

	public void setP_received_time(Date p_received_time) {
		this.p_received_time = p_received_time;
	}

	public Date getP_create_date() {
		return p_create_date;
	}

	public void setP_create_date(Date p_create_date) {
		this.p_create_date = p_create_date;
	}

	public Date getP_create_time() {
		return p_create_time;
	}

	public void setP_create_time(Date p_create_time) {
		this.p_create_time = p_create_time;
	}

	public Date getP_last_upd_time() {
		return p_last_upd_time;
	}

	public void setP_last_upd_time(Date p_last_upd_time) {
		this.p_last_upd_time = p_last_upd_time;
	}

	public String getP_int_order_no() {
		return p_int_order_no;
	}

	public void setP_int_order_no(String p_int_order_no) {
		this.p_int_order_no = p_int_order_no;
	}

	public String getP_int_txn_no() {
		return p_int_txn_no;
	}

	public void setP_int_txn_no(String p_int_txn_no) {
		this.p_int_txn_no = p_int_txn_no;
	}

	public String getP_req_order_no() {
		return p_req_order_no;
	}

	public void setP_req_order_no(String p_req_order_no) {
		this.p_req_order_no = p_req_order_no;
	}

	public String getP_int_trade_no() {
		return p_int_trade_no;
	}

	public void setP_int_trade_no(String p_int_trade_no) {
		this.p_int_trade_no = p_int_trade_no;
	}

	public String getP_old_statues() {
		return p_old_statues;
	}

	public void setP_old_statues(String p_old_statues) {
		this.p_old_statues = p_old_statues;
	}

	public String getA_activity_no() {
		return a_activity_no;
	}

	public void setA_activity_no(String a_activity_no) {
		this.a_activity_no = a_activity_no;
	}

	public String getA_gift_type() {
		return a_gift_type;
	}

	public void setA_gift_type(String a_gift_type) {
		this.a_gift_type = a_gift_type;
	}

	public String getA_service_type() {
		return a_service_type;
	}

	public void setA_service_type(String a_service_type) {
		this.a_service_type = a_service_type;
	}

	public String getA_pay_channel() {
		return a_pay_channel;
	}

	public void setA_pay_channel(String a_pay_channel) {
		this.a_pay_channel = a_pay_channel;
	}

	public String getA_is_fixed_amt() {
		return a_is_fixed_amt;
	}

	public void setA_is_fixed_amt(String a_is_fixed_amt) {
		this.a_is_fixed_amt = a_is_fixed_amt;
	}

	public String getA_activity_name() {
		return a_activity_name;
	}

	public void setA_activity_name(String a_activity_name) {
		this.a_activity_name = a_activity_name;
	}

	public String getA_status() {
		return a_status;
	}

	public void setA_status(String a_status) {
		this.a_status = a_status;
	}

	public String getA_sponsor() {
		return a_sponsor;
	}

	public void setA_sponsor(String a_sponsor) {
		this.a_sponsor = a_sponsor;
	}

	public BigDecimal getA_budget() {
		return a_budget;
	}

	public void setA_budget(BigDecimal a_budget) {
		this.a_budget = a_budget;
	}

	public Integer getA_quantity() {
		return a_quantity;
	}

	public void setA_quantity(Integer a_quantity) {
		this.a_quantity = a_quantity;
	}

	public Integer getA_limited_quantity() {
		return a_limited_quantity;
	}

	public void setA_limited_quantity(Integer a_limited_quantity) {
		this.a_limited_quantity = a_limited_quantity;
	}

	public String getA_platform_type() {
		return a_platform_type;
	}

	public void setA_platform_type(String a_platform_type) {
		this.a_platform_type = a_platform_type;
	}

	public String getA_app_id() {
		return a_app_id;
	}

	public void setA_app_id(String a_app_id) {
		this.a_app_id = a_app_id;
	}

	public String getA_scene() {
		return a_scene;
	}

	public void setA_scene(String a_scene) {
		this.a_scene = a_scene;
	}

	public String getA_rule_type() {
		return a_rule_type;
	}

	public void setA_rule_type(String a_rule_type) {
		this.a_rule_type = a_rule_type;
	}

	public String getA_rule_param() {
		return a_rule_param;
	}

	public void setA_rule_param(String a_rule_param) {
		this.a_rule_param = a_rule_param;
	}

	public String getA_logo_url() {
		return a_logo_url;
	}

	public void setA_logo_url(String a_logo_url) {
		this.a_logo_url = a_logo_url;
	}

	public String getA_wish_desc() {
		return a_wish_desc;
	}

	public void setA_wish_desc(String a_wish_desc) {
		this.a_wish_desc = a_wish_desc;
	}

	public String getA_share_desc() {
		return a_share_desc;
	}

	public void setA_share_desc(String a_share_desc) {
		this.a_share_desc = a_share_desc;
	}

	public String getA_share_statement() {
		return a_share_statement;
	}

	public void setA_share_statement(String a_share_statement) {
		this.a_share_statement = a_share_statement;
	}

	public String getA_share_pic_url() {
		return a_share_pic_url;
	}

	public void setA_share_pic_url(String a_share_pic_url) {
		this.a_share_pic_url = a_share_pic_url;
	}

	public String getA_share_url() {
		return a_share_url;
	}

	public void setA_share_url(String a_share_url) {
		this.a_share_url = a_share_url;
	}

	public Date getA_effc_time() {
		return a_effc_time;
	}

	public void setA_effc_time(Date a_effc_time) {
		this.a_effc_time = a_effc_time;
	}

	public Date getA_expired_time() {
		return a_expired_time;
	}

	public void setA_expired_time(Date a_expired_time) {
		this.a_expired_time = a_expired_time;
	}

	public Date getA_ceate_date() {
		return a_ceate_date;
	}

	public void setA_ceate_date(Date a_ceate_date) {
		this.a_ceate_date = a_ceate_date;
	}

	public Date getA_create_time() {
		return a_create_time;
	}

	public void setA_create_time(Date a_create_time) {
		this.a_create_time = a_create_time;
	}

	public Date getA_last_upd_time() {
		return a_last_upd_time;
	}

	public void setA_last_upd_time(Date a_last_upd_time) {
		this.a_last_upd_time = a_last_upd_time;
	}

	public String getA_operator() {
		return a_operator;
	}

	public void setA_operator(String a_operator) {
		this.a_operator = a_operator;
	}

	public String getA_auditor() {
		return a_auditor;
	}

	public void setA_auditor(String a_auditor) {
		this.a_auditor = a_auditor;
	}

	public String getA_min_status() {
		return a_min_status;
	}

	public void setA_min_status(String a_min_status) {
		this.a_min_status = a_min_status;
	}

	public String getA_max_status() {
		return a_max_status;
	}

	public void setA_max_status(String a_max_status) {
		this.a_max_status = a_max_status;
	}

	public String getA_activity_desc() {
		return a_activity_desc;
	}

	public void setA_activity_desc(String a_activity_desc) {
		this.a_activity_desc = a_activity_desc;
	}

	public String getA_mark() {
		return a_mark;
	}

	public void setA_mark(String a_mark) {
		this.a_mark = a_mark;
	}
 
}
