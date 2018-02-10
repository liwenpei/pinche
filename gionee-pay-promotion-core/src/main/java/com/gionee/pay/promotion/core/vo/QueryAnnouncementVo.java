package com.gionee.pay.promotion.core.vo;

import com.gionee.common.vo.BaseVo;

/**
 * @author dingyw
 *
 * 2016年7月27日
 */
public class QueryAnnouncementVo extends BaseVo{
	
	/**
	 *商户app_id 
	 */
	private String app_id;

	/**
	 * 交易流水号	公告编号
	 */
	private String announce_id;
	
	/**
	 * 公告名称	公告名称
	 */
	private String announce_name;
	
	/**
	 * 悬浮窗标题	宣传语
	 */
	private String floating_window_title;
	
	/**
	 * 对话窗标题	点击悬浮窗后提示对话框的标题
	 */
	private String dialog_title;
	
	/**
	 * 对话框图片url	url地址
	 */
	private String dialog_pic_url;
	
	
	/**
	 * 公告内容	公告内容（HTML格式）
	 */
	private String dialog_content;

	public String getApp_id() {
		return app_id;
	}

	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}

	public String getAnnounce_id() {
		return announce_id;
	}

	public void setAnnounce_id(String announce_id) {
		this.announce_id = announce_id;
	}

	public String getAnnounce_name() {
		return announce_name;
	}

	public void setAnnounce_name(String announce_name) {
		this.announce_name = announce_name;
	}

	public String getFloating_window_title() {
		return floating_window_title;
	}

	public void setFloating_window_title(String floating_window_title) {
		this.floating_window_title = floating_window_title;
	}

	public String getDialog_title() {
		return dialog_title;
	}

	public void setDialog_title(String dialog_title) {
		this.dialog_title = dialog_title;
	}

	public String getDialog_pic_url() {
		return dialog_pic_url;
	}

	public void setDialog_pic_url(String dialog_pic_url) {
		this.dialog_pic_url = dialog_pic_url;
	}

	public String getDialog_content() {
		return dialog_content;
	}

	public void setDialog_content(String dialog_content) {
		this.dialog_content = dialog_content;
	}
	
	

}
