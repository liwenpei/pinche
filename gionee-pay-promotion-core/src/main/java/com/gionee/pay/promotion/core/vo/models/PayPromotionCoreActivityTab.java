package com.gionee.pay.promotion.core.vo.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.gionee.common.vo.BaseVo;

public class PayPromotionCoreActivityTab extends BaseVo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String activity_no;

    private String gift_type;

    private String service_type;

    private String pay_channel;

    private String is_fixed_amt;

    private String activity_name;

    private String status;

    private String sponsor;

    private BigDecimal budget;

    private Integer quantity;

    private Integer limited_quantity;

    private String platform_type;

    private String app_id;

    private String scene;

    private String rule_type;

    private String rule_param;

    private String logo_url;

    private String wish_desc;
    
    private String share_desc;

    private String share_statement;

    private String share_pic_url;

    private String share_url;
    
    private Date effc_time;
    private Date expired_time;

    private Date ceate_date;

    private Date create_time;

    private Date last_upd_time;

    private String operator;

    private String auditor;

    
    private String min_status;//作为判断sql的标准,不操作数据库
    private String max_status;//作为判断sql的标准,不操作数据库
    
    private String activity_desc;
    
    private String mark;
    public String getActivity_no() {
        return activity_no;
    }

    public void setActivity_no(String activity_no) {
        this.activity_no = activity_no;
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

    public String getPay_channel() {
        return pay_channel;
    }

    public void setPay_channel(String pay_channel) {
        this.pay_channel = pay_channel;
    }

    public String getIs_fixed_amt() {
        return is_fixed_amt;
    }

    public void setIs_fixed_amt(String is_fixed_amt) {
        this.is_fixed_amt = is_fixed_amt;
    }

    public String getActivity_name() {
        return activity_name;
    }

    public void setActivity_name(String activity_name) {
        this.activity_name = activity_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
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

    public String getLogo_url() {
        return logo_url;
    }

    public void setLogo_url(String logo_url) {
        this.logo_url = logo_url;
    }

    public String getWish_desc() {
        return wish_desc;
    }

    public void setWish_desc(String wish_desc) {
        this.wish_desc = wish_desc;
    }

    public String getShare_statement() {
        return share_statement;
    }

    public void setShare_statement(String share_statement) {
        this.share_statement = share_statement;
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

    public Date getCeate_date() {
        return ceate_date;
    }

    public void setCeate_date(Date ceate_date) {
        this.ceate_date = ceate_date;
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

	public String getShare_desc() {
		return share_desc;
	}

	public void setShare_desc(String share_desc) {
		this.share_desc = share_desc;
	}

	public String getMin_status() {
		return min_status;
	}

	public void setMin_status(String min_status) {
		this.min_status = min_status;
	}

	public String getMax_status() {
		return max_status;
	}

	public void setMax_status(String max_status) {
		this.max_status = max_status;
	}

	public String getActivity_desc() {
		return activity_desc;
	}

	public void setActivity_desc(String activity_desc) {
		this.activity_desc = activity_desc;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

 
	
}