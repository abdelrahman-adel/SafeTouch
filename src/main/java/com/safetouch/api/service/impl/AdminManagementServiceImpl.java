package com.safetouch.api.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.safetouch.api.models.AdminType;
import com.safetouch.api.models.StatusEnum;
import com.safetouch.api.models.UserType;
import com.safetouch.api.service.AdminManagementService;
import com.safetouch.api.service.request.LoginRqType;
import com.safetouch.api.service.request.RegisterRqType;
import com.safetouch.api.service.response.CheckNotificationRsType;
import com.safetouch.api.service.response.LoginRsType;
import com.safetouch.api.service.response.RegisterRsType;
import com.safetouch.dal.daos.AdminDao;
import com.safetouch.dal.daos.UserDao;

@Service
public class AdminManagementServiceImpl implements AdminManagementService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AdminManagementServiceImpl.class);

	@Autowired
	private UserDao userDao;

	@Autowired
	private AdminDao adminDao;

	@Override
	public LoginRsType login(LoginRqType loginInfo) {
		AdminType admin = adminDao.findByEmailAndPassword(loginInfo.getEmail(), loginInfo.getPassword());

		StatusEnum status = null;
		if (admin != null) {
			status = StatusEnum.SUCCESS;
		} else {
			status = StatusEnum.INVALID_CREDS;
		}

		LoginRsType loginRs = new LoginRsType();
		loginRs.setStatus(status);
		loginRs.setAdminType(admin);

		return loginRs;
	}

	@Override
	public RegisterRsType register(RegisterRqType registerRqType) {
		AdminType createdAdmin = null;
		StatusEnum status = null;

		try {
			if (registerRqType != null && registerRqType.getAdminType() != null) {
				createdAdmin = adminDao.createAdmin(registerRqType.getAdminType());
			}
		} catch (DataIntegrityViolationException ex) {
			status = StatusEnum.EMAIL_ALREADY_USED;
		}

		if (createdAdmin != null) {
			status = StatusEnum.SUCCESS;
		} else {
			status = StatusEnum.ERROR_REGISTERING_ADMIN;
		}

		RegisterRsType registerRs = new RegisterRsType();
		registerRs.setStatus(status);
		registerRs.setAdminType(createdAdmin);

		return registerRs;
	}

	@Override
	public CheckNotificationRsType checkNotification(String email) {
		UserType user = userDao.findByEmail(email);
		// TODO Auto-generated method stub
		return null;
	}

}
