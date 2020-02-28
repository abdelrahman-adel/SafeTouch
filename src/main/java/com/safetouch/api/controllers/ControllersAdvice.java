package com.safetouch.api.controllers;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.safetouch.api.models.StatusEnum;
import com.safetouch.api.service.response.BaseResponse;

@RestControllerAdvice
public class ControllersAdvice {

	@ExceptionHandler(value = Exception.class)
	public BaseResponse exceptionHandler() {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatus(StatusEnum.FAILURE);
		return baseResponse;
	}
}
