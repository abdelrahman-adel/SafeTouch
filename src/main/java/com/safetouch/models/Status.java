package com.safetouch.models;

public class Status {

	private String statusCode;
	private String statusDesc;

	public Status(StatusEnum status) {
		this.statusCode = status.getStatusCode();
		this.statusDesc = status.getStatusDesc();
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String shortDesc) {
		this.statusDesc = shortDesc;
	}

}
