package com.safetouch.api.service;

import com.safetouch.api.service.request.AlertRqType;
import com.safetouch.api.service.request.LoginRqType;
import com.safetouch.api.service.request.RegisterRqType;
import com.safetouch.api.service.response.AlertRsType;
import com.safetouch.api.service.response.FindRsType;
import com.safetouch.api.service.response.LoginRsType;
import com.safetouch.api.service.response.RegisterRsType;
import com.safetouch.exceptions.BusinessException;

public interface UserManagementService {

	LoginRsType login(LoginRqType loginRqType) throws BusinessException;

	RegisterRsType register(RegisterRqType registerRqType) throws BusinessException;

	FindRsType find(String email) throws BusinessException;

	AlertRsType alert(AlertRqType alertRqType) throws BusinessException;
}
