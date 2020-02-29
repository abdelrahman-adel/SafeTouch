package com.safetouch.api.service.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.safetouch.api.models.UserType;

public class FindRsType extends BaseResponse {

	@JsonProperty("user")
	private UserType userType;

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType user) {
		this.userType = user;
	}
}
