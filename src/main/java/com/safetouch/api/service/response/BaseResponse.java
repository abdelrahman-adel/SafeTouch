package com.safetouch.api.service.response;

import com.safetouch.api.models.StatusType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.safetouch.api.models.StatusEnum;

public class BaseResponse {

	@JsonProperty("status")
	private StatusEnum status;

	public StatusType getStatus() {
		return new StatusType(status);
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}
}
