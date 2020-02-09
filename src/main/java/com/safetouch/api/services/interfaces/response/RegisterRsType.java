package com.safetouch.api.services.interfaces.response;

import com.safetouch.api.models.UserType;

public class RegisterRsType extends BaseResponse {

	private UserType user;

	public UserType getUser() {
		return user;
	}

	public void setUser(UserType user) {
		this.user = user;
	}
}
