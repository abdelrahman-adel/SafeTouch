package com.safetouch.exceptions;

import com.safetouch.api.models.StatusEnum;

public class BusinessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5772033862392301066L;

	private StatusEnum status;

	public BusinessException(StatusEnum status) {
		super(status.getDesc());
		this.setStatus(status);
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

}
