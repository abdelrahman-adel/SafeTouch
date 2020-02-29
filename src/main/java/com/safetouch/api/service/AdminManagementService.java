package com.safetouch.api.service;

import com.safetouch.api.service.request.LoginRqType;
import com.safetouch.api.service.request.RegisterRqType;
import com.safetouch.api.service.response.CheckNotificationRsType;
import com.safetouch.api.service.response.LoginRsType;
import com.safetouch.api.service.response.RegisterRsType;
import com.safetouch.exceptions.BusinessException;

public interface AdminManagementService {

	CheckNotificationRsType checkNotification(String email) throws BusinessException;

	LoginRsType login(LoginRqType loginRqType) throws BusinessException;

	RegisterRsType register(RegisterRqType registerRqType) throws BusinessException;
}
