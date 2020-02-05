package com.safetouch.services;

import com.safetouch.models.LoginInfo;
import com.safetouch.models.UserInfo;
import com.safetouch.services.interfaces.UserInfoRs;

public interface UserManagementService {

	UserInfoRs login(LoginInfo loginInfo);

	UserInfoRs register(UserInfo userInfo);

	UserInfoRs find(String email);
}
