package com.gionee.pay.promotion.core.vo.models;

import java.math.BigDecimal;
import java.util.Date;

public class PayPromotionCoreWechatRedPackageTab extends PayPromotionCoreWechatRedPackageTabKey {
    private String activity_name;

    private BigDecimal amt;

    private String status;

    private String user_id;

    private String wechat_open_id;

    private Date received_time;

    private Date create_date;

    private Date create_time;

    private Date last_upd_time;
    
    private String int_order_no;
    
    private String int_txn_no;
    
    private String req_order_no;
    
    private String int_trade_no;

    private String old_statues;
    
    public String getActivity_name() {
        return activity_name;
    }

    public void setActivity_name(String activity_name) {
        this.activity_name = activity_name;
    }

    public BigDecimal getAmt() {
        return amt;
    }

    public void setAmt(BigDecimal amt) {
        this.amt = amt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Date getReceived_time() {
        return received_time;
    }

    public void setReceived_time(Date received_time) {
        this.received_time = received_time;
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

	public String getInt_order_no() {
		return int_order_no;
	}

	public void setInt_order_no(String int_order_no) {
		this.int_order_no = int_order_no;
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

	public String getReq_order_no() {
		return req_order_no;
	}

	public void setReq_order_no(String req_order_no) {
		this.req_order_no = req_order_no;
	}

	public String getOld_statues() {
		return old_statues;
	}

	public void setOld_statues(String old_statues) {
		this.old_statues = old_statues;
	}
    
    
}