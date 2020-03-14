package com.safetouch.api.models;

import org.springframework.http.HttpStatus;

public enum StatusEnum {

	SUCCESS("00", "Success", HttpStatus.OK),
	FAILURE("99", "Unknown failure", HttpStatus.INTERNAL_SERVER_ERROR),
	BAD_REQUEST("98", "Bad request", HttpStatus.BAD_REQUEST),
	INVALID_CREDS("01", "Invalid credentials", HttpStatus.OK),
	USER_NOT_FOUND("02", "User not found", HttpStatus.OK),
	ERROR_REGISTERING_USER("03", "Error registering user", HttpStatus.OK),
	EMAIL_ALREADY_USED("04", "Email already used", HttpStatus.OK),
	ERROR_REGISTERING_ADMIN("05", "Error registering admin", HttpStatus.OK),
	ADMIN_NOT_FOUND("06", "Admin not found", HttpStatus.OK),
	SYSTEM_HAS_NO_ADMINS("07", "System has no admins", HttpStatus.OK),
	NO_NOTIFICATIONS_FOUND("08", "No notifications found", HttpStatus.OK),
	NOTIFICATION_UPDATE_FAILED("09", "Notification update failed", HttpStatus.OK),
	NO_SUCH_NOTIFICATION("10", "No such notification", HttpStatus.OK),
	NO_REACTION_YET("11", "No reaction yet", HttpStatus.OK),
	CASE_HAS_BEEN_IGNORED("12", "Case has been ignored", HttpStatus.OK),
	CASE_HAS_BEEN_ACCEPTED("13", "Case has been accepted", HttpStatus.OK);

	private String code;
	private String desc;
	private HttpStatus httpStatus;

	private StatusEnum(String code, String desc, HttpStatus httpStatus) {
		this.code = code;
		this.desc = desc;
		this.httpStatus = httpStatus;
	}

	public static StatusEnum fromStatusCode(String code) {
		for (StatusEnum status : values()) {
			if (status.getCode().equals(code)) {
				return status;
			}
		}
		return null;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
}
