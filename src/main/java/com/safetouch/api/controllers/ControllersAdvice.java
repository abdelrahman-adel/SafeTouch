package com.safetouch.api.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.safetouch.api.models.StatusEnum;
import com.safetouch.api.service.response.BaseResponse;
import com.safetouch.exceptions.BusinessException;
import com.safetouch.exceptions.SystemException;

@RestControllerAdvice
public class ControllersAdvice {

	private static final Logger LOGGER = LoggerFactory.getLogger(ControllersAdvice.class);

	@ExceptionHandler(value = Exception.class)
	public BaseResponse exceptionHandler(Exception e) {
		LOGGER.error("EXCEPTION TRACE: ", e);
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatus(StatusEnum.FAILURE);
		return baseResponse;
	}

	@ExceptionHandler(value = BusinessException.class)
	public BaseResponse businessExceptionHandler(BusinessException e) {
		LOGGER.error("EXCEPTION TRACE: ", e);
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatus(e.getStatus());
		return baseResponse;
	}

	@ExceptionHandler(value = SystemException.class)
	public BaseResponse systemExceptionHandler(SystemException e) {
		LOGGER.error("EXCEPTION TRACE: ", e);
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatus(e.getStatus());
		return baseResponse;
	}
}
