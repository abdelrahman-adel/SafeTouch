package com.safetouch.api.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.safetouch.api.models.StatusEnum;
import com.safetouch.api.models.UserType;
import com.safetouch.api.service.UserManagementService;
import com.safetouch.api.service.request.AlertRqType;
import com.safetouch.api.service.request.LoginRqType;
import com.safetouch.api.service.request.RegisterRqType;
import com.safetouch.api.service.response.AlertRsType;
import com.safetouch.api.service.response.FindRsType;
import com.safetouch.api.service.response.LoginRsType;
import com.safetouch.api.service.response.RegisterRsType;
import com.safetouch.dal.daos.UserDao;

@Service
public class UserManagementServiceImpl implements UserManagementService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserManagementServiceImpl.class);

	@Autowired
	private UserDao userDao;

	@Override
	public LoginRsType login(LoginRqType loginInfo) {
		UserType user = userDao.findByEmailAndPassword(loginInfo.getEmail(), loginInfo.getPassword());

		StatusEnum status = null;
		if (user != null) {
			status = StatusEnum.SUCCESS;
		} else {
			status = StatusEnum.INVALID_CREDS;
		}

		LoginRsType loginRs = new LoginRsType();
		loginRs.setStatus(status);
		loginRs.setUserType(user);

		return loginRs;
	}

	@Override
	public RegisterRsType register(RegisterRqType registerRqType) {
		UserType createdUser = null;
		StatusEnum status = null;

		try {
			if (registerRqType != null && registerRqType.getUserType() != null) {
				createdUser = userDao.createUser(registerRqType.getUserType());
			}
		} catch (DataIntegrityViolationException ex) {
			status = StatusEnum.EMAIL_ALREADY_USED;
		}

		if (createdUser != null) {
			status = StatusEnum.SUCCESS;
		} else {
			status = StatusEnum.ERROR_REGISTERING_USER;
		}

		RegisterRsType registerRs = new RegisterRsType();
		registerRs.setStatus(status);
		registerRs.setUserType(createdUser);

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

	@Override
	public AlertRsType alert(AlertRqType alertRqType) {
		UserType userType = userDao.findByEmail(alertRqType.getEmail());

		StatusEnum status = null;
		if (userType != null) {
			status = StatusEnum.SUCCESS;
		} else {
			status = StatusEnum.USER_NOT_FOUND;
		}

		AlertRsType alertRs = new AlertRsType();
		alertRs.setStatus(status);
		alertRs.setUser(userType);

		return alertRs;
	}
}
