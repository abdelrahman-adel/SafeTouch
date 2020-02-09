package com.safetouch.api.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetouch.api.models.LoginInfoType;
import com.safetouch.api.models.StatusEnum;
import com.safetouch.api.models.UserType;
import com.safetouch.api.services.UserManagementService;
import com.safetouch.api.services.interfaces.response.FindRsType;
import com.safetouch.api.services.interfaces.response.LoginRsType;
import com.safetouch.api.services.interfaces.response.RegisterRsType;
import com.safetouch.dal.daos.UserDao;

@Service
public class UserManagementServiceImpl implements UserManagementService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserManagementServiceImpl.class);

	@Autowired
	private UserDao userDao;

	@Override
	public LoginRsType login(LoginInfoType loginInfo) {
		UserType user = userDao.findByEmailAndPassword(loginInfo.getEmail(), loginInfo.getPassword());

		StatusEnum status = null;
		if (user != null) {
			status = StatusEnum.SUCCESS;
		} else {
			status = StatusEnum.INVALID_CREDS;
		}

		LoginRsType loginRs = new LoginRsType();
		loginRs.setStatus(status);
		loginRs.setUser(user);

		return loginRs;
	}

	@Override
	public RegisterRsType register(UserType userType) {
		UserType createdUser = userDao.createUser(userType);

		StatusEnum status = null;
		if (createdUser != null) {
			status = StatusEnum.SUCCESS;
		} else {
			status = StatusEnum.ERROR_REGISTERING_USER;
		}

		RegisterRsType registerRs = new RegisterRsType();
		registerRs.setStatus(status);
		registerRs.setUser(createdUser);

		return registerRs;
	}

	@Override
	public FindRsType find(String email) {
		UserType userType = userDao.findByEmail(email);

		StatusEnum status = null;
		if (userType != null) {
			status = StatusEnum.SUCCESS;
		} else {
			status = StatusEnum.USER_NOT_FOUND;
		}

		FindRsType findRs = new FindRsType();
		findRs.setStatus(status);
		findRs.setUser(userType);

		return findRs;
	}
}
