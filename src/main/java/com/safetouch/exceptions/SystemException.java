package com.safetouch.exceptions;

import com.safetouch.api.models.StatusEnum;

public class SystemException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2745332873976694033L;

	private StatusEnum status;

	public SystemException() {
		super(StatusEnum.FAILURE.getDesc());
		this.setStatus(StatusEnum.FAILURE);
	}

	public SystemException(StatusEnum status) {
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
