package com.safetouch.api.service.response;

import com.safetouch.api.models.UserType;

public class FindRsType extends BaseResponse {

	private UserType user;

	public UserType getUser() {
		return user;
	}

	public void setUser(UserType user) {
		this.user = user;
	}
}
