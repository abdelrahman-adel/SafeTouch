package com.safetouch.api.models;

public class StatusType {

	private String code;
	private String desc;

	public StatusType(StatusEnum status) {
		this.code = status.getCode();
		this.desc = status.getDesc();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
