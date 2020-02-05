package com.safetouch.services.interfaces;

import com.safetouch.models.Status;
import com.safetouch.models.StatusEnum;
import com.safetouch.models.UserInfo;

public class UserInfoRs {

	private StatusEnum status;
	private UserInfo userInfo;

	public Status getStatus() {
		return new Status(status);
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
}
