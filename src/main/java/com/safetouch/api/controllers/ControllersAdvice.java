package com.safetouch.api.controllers;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.safetouch.api.models.StatusEnum;
import com.safetouch.api.services.interfaces.response.BaseResponse;

@RestControllerAdvice
public class ControllersAdvice {

	@ExceptionHandler(value = DataIntegrityViolationException.class)
	public BaseResponse dataIntegrityViolationExceptionHandler() {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatus(StatusEnum.EMAIL_ALREADY_USED);
		return baseResponse;
	}

	@ExceptionHandler(value = Exception.class)
	public BaseResponse exceptionHandler() {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatus(StatusEnum.FAILURE);
		return baseResponse;
	}
}
