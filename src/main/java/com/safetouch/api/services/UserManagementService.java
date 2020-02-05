package com.safetouch.api.services;

import com.safetouch.api.models.LoginInfo;
import com.safetouch.api.models.UserInfo;
import com.safetouch.api.services.interfaces.UserInfoRs;

public interface UserManagementService {

	UserInfoRs login(LoginInfo loginInfo);

	UserInfoRs register(UserInfo userInfo);

	UserInfoRs find(String email);
}
