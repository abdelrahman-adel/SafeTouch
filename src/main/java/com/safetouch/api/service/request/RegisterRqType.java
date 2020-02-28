package com.safetouch.api.service.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.safetouch.api.models.AdminType;
import com.safetouch.api.models.UserType;

public class RegisterRqType {

	@JsonProperty("user")
	private UserType userType;

	@JsonProperty("admin")
	private AdminType adminType;

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public AdminType getAdminType() {
		return adminType;
	}

	public void setAdminType(AdminType adminType) {
		this.adminType = adminType;
	}
}
