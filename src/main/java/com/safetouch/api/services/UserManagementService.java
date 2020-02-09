package com.safetouch.api.services;

import com.safetouch.api.models.LoginInfoType;
import com.safetouch.api.models.UserType;
import com.safetouch.api.services.interfaces.response.FindRsType;
import com.safetouch.api.services.interfaces.response.LoginRsType;
import com.safetouch.api.services.interfaces.response.RegisterRsType;

public interface UserManagementService {

	LoginRsType login(LoginInfoType loginInfo);

	RegisterRsType register(UserType userInfo);

	FindRsType find(String email);
}
