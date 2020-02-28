package com.safetouch.api.service;

import com.safetouch.api.service.request.AlertRqType;
import com.safetouch.api.service.request.LoginRqType;
import com.safetouch.api.service.request.RegisterRqType;
import com.safetouch.api.service.response.AlertRsType;
import com.safetouch.api.service.response.FindRsType;
import com.safetouch.api.service.response.LoginRsType;
import com.safetouch.api.service.response.RegisterRsType;

public interface UserManagementService {

	LoginRsType login(LoginRqType loginRqType);

	RegisterRsType register(RegisterRqType registerRqType);

	FindRsType find(String email);

	AlertRsType alert(AlertRqType alertRqType);
}
