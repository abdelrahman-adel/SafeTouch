package com.safetouch.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatusType {

	@JsonProperty("code")
	private String code;

	@JsonProperty("desc")
	private String desc;

	public StatusType(StatusEnum status) {
		this.code = status.getCode();
		this.desc = status.getDesc();
	}

	public void setStatus(StatusEnum status) {
		this.code = status.getCode();
		this.desc = status.getDesc();
	}

}
