package com.safetouch.api.service;

import com.safetouch.api.service.request.LoginRqType;
import com.safetouch.api.service.request.RegisterRqType;
import com.safetouch.api.service.response.CheckNotificationRsType;
import com.safetouch.api.service.response.LoginRsType;
import com.safetouch.api.service.response.RegisterRsType;

public interface AdminManagementService {

	CheckNotificationRsType checkNotification(String email);

	LoginRsType login(LoginRqType loginRqType);

	RegisterRsType register(RegisterRqType registerRqType);
}
