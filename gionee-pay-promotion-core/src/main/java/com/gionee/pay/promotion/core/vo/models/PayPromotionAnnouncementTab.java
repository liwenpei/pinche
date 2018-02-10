package com.gionee.pay.promotion.core.vo.models;

import java.io.Serializable;
import java.util.Date;

import com.gionee.common.vo.BaseVo;

public class PayPromotionAnnouncementTab extends BaseVo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 216073886565610632L;

	private Integer announce_id;

    private String announce_name;

    private String platform_type;

    private String app_id;

    private String slogan;

    private String pic_url;

    private String announce_content;

    private String announce_content_url;

    private String status;

    private Date effc_time;

    private Date expired_time;

    private Date create_date;

    private Date create_time;

    private Date last_upd_time;

    private String operator;

    private String auditor;

  

    public Integer getAnnounce_id() {
		return announce_id;
	}

	public void setAnnounce_id(Integer announce_id) {
		this.announce_id = announce_id;
	}

	public String getAnnounce_name() {
        return announce_name;
    }

    public void setAnnounce_name(String announce_name) {
        this.announce_name = announce_name;
    }

    public String getPlatform_type() {
        return platform_type;
    }

    public void setPlatform_type(String platform_type) {
        this.platform_type = platform_type;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public String getAnnounce_content() {
        return announce_content;
    }

    public void setAnnounce_content(String announce_content) {
        this.announce_content = announce_content;
    }

    public String getAnnounce_content_url() {
        return announce_content_url;
    }

    public void setAnnounce_content_url(String announce_content_url) {
        this.announce_content_url = announce_content_url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
}