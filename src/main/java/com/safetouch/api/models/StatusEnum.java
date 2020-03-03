package com.safetouch.api.models;

public enum StatusEnum {

	SUCCESS("00", "Success"),
	FAILURE("99", "Unknown failure"),
	BAD_REQUEST("98", "Bad request"),
	INVALID_CREDS("01", "Invalid credentials"),
	USER_NOT_FOUND("02", "User not found"),
	ERROR_REGISTERING_USER("03", "Error registering user"),
	EMAIL_ALREADY_USED("04", "Email already used"),
	ERROR_REGISTERING_ADMIN("05", "Error registering admin"),
	ADMIN_NOT_FOUND("06", "Admin not found"),
	SYSTEM_HAS_NO_ADMINS("07", "System has no admins"),
	NO_NOTIFICATIONS_FOUND("08", "No notifications found"),
	NOTIFICATION_UPDATE_FAILED("09", "Notification update failed"),
	NO_SUCH_NOTIFICATION("10", "No such notification");

	private String code;
	private String desc;

	private StatusEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
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
}
