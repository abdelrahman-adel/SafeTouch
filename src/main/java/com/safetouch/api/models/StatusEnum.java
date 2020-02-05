package com.safetouch.api.models;

public enum StatusEnum {

	SUCCESS("00", "Success"),
	FAILURE("99", "Unknown failure"),
	INVALID_CREDS("01", "Invalid credentials"),
	USER_NOT_FOUND("02", "User not found"),
	ERROR_REGISTERING_USER("03", "Error registering user");

	private String statusCode;
	private String statusDesc;

	private StatusEnum(String statusCode, String statusDesc) {
		this.statusCode = statusCode;
		this.statusDesc = statusDesc;
	}

	public static StatusEnum fromStatusCode(String statusCode) {
		for (StatusEnum status : values()) {
			if (status.getStatusCode().equals(statusCode)) {
				return status;
			}
		}
		return null;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public String getStatusDesc() {
		return statusDesc;
	}
}
