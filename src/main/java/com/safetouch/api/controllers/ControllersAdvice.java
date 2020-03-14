package com.safetouch.api.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.safetouch.api.models.StatusEnum;
import com.safetouch.api.service.response.BaseResponse;
import com.safetouch.exceptions.BusinessException;
import com.safetouch.exceptions.SystemException;

@RestControllerAdvice
public class ControllersAdvice {

	private static final Logger LOGGER = LoggerFactory.getLogger(ControllersAdvice.class);

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<BaseResponse> validationHandler(MethodArgumentNotValidException e, HttpStatus status) {
		LOGGER.error("EXCEPTION TRACE: ", e);
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatus(StatusEnum.BAD_REQUEST);
		return new ResponseEntity<>(baseResponse, StatusEnum.BAD_REQUEST.getHttpStatus());
	}

	@ExceptionHandler(value = BusinessException.class)
	public ResponseEntity<BaseResponse> businessExceptionHandler(BusinessException e) {
		LOGGER.error("EXCEPTION TRACE: ", e);
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatus(e.getStatus());
		return new ResponseEntity<>(baseResponse, e.getStatus().getHttpStatus());
	}

	@ExceptionHandler(value = SystemException.class)
	public ResponseEntity<BaseResponse> systemExceptionHandler(SystemException e) {
		LOGGER.error("EXCEPTION TRACE: ", e);
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatus(e.getStatus());
		return new ResponseEntity<>(baseResponse, e.getStatus().getHttpStatus());
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<BaseResponse> exceptionHandler(Exception e) {
		LOGGER.error("EXCEPTION TRACE: ", e);
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatus(StatusEnum.FAILURE);
		return new ResponseEntity<>(baseResponse, StatusEnum.FAILURE.getHttpStatus());
	}
}
