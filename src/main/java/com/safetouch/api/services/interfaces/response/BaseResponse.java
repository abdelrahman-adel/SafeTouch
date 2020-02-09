package com.safetouch.api.services.interfaces.response;

import com.safetouch.api.models.StatusType;
import com.safetouch.api.models.StatusEnum;

public class BaseResponse {

	private StatusEnum status;

	public StatusType getStatus() {
		return new StatusType(status);
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}
}
