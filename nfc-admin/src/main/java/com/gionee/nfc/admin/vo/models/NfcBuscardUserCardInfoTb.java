package com.gionee.nfc.admin.vo.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class NfcBuscardUserCardInfoTb extends NfcBuscardUserCardInfoTbKey {
    private String card_no;

    private String card_id;

    private String city_code;

    private String user_id;

    private String phone_no;

    private String pay_type;

    private String card_product_name;

    private String card_img_url;

    private String customer_service_tel_no;

    private String imei;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date create_date;

    private Date create_time;

    private Date last_upd_time;

    public String getCard_no() {
        return card_no;
    }

    public void setCard_no(String card_no) {
        this.card_no = card_no;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public String getCity_code() {
        return city_code;
    }

    public void setCity_code(String city_code) {
        this.city_code = city_code;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getPay_type() {
        return pay_type;
    }

    public void setPay_type(String pay_type) {
        this.pay_type = pay_type;
    }

    public String getCard_product_name() {
        return card_product_name;
    }

    public void setCard_product_name(String card_product_name) {
        this.card_product_name = card_product_name;
    }

    public String getCard_img_url() {
        return card_img_url;
    }

    public void setCard_img_url(String card_img_url) {
        this.card_img_url = card_img_url;
    }

    public String getCustomer_service_tel_no() {
        return customer_service_tel_no;
    }

    public void setCustomer_service_tel_no(String customer_service_tel_no) {
        this.customer_service_tel_no = customer_service_tel_no;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getLast_upd_time() {
        return last_upd_time;
    }

    public void setLast_upd_time(Date last_upd_time) {
        this.last_upd_time = last_upd_time;
    }
}