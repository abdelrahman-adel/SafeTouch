package com.safetouch.api.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.safetouch.api.models.AdminType;
import com.safetouch.api.models.StatusEnum;
import com.safetouch.api.service.AdminManagementService;
import com.safetouch.api.service.request.LoginRqType;
import com.safetouch.api.service.request.RegisterRqType;
import com.safetouch.api.service.response.CheckNotificationRsType;
import com.safetouch.api.service.response.LoginRsType;
import com.safetouch.api.service.response.RegisterRsType;
import com.safetouch.dal.daos.AdminDao;
import com.safetouch.exceptions.BusinessException;

@Service
public class AdminManagementServiceImpl implements AdminManagementService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AdminManagementServiceImpl.class);

	@Autowired
	private AdminDao adminDao;

	@Override
	public LoginRsType login(LoginRqType loginInfo) throws BusinessException {
		AdminType admin = adminDao.findByEmailAndPassword(loginInfo.getEmail(), loginInfo.getPassword());

		if (admin == null) {
			throw new BusinessException(StatusEnum.INVALID_CREDS);
		}

		LoginRsType loginRs = new LoginRsType();
		loginRs.setStatus(StatusEnum.SUCCESS);
		loginRs.setAdminType(admin);

		return loginRs;
	}

	@Override
	public RegisterRsType register(RegisterRqType registerRqType) throws BusinessException {
		AdminType createdAdmin = null;

		try {
			if (registerRqType != null && registerRqType.getAdminType() != null) {
				createdAdmin = adminDao.createAdmin(registerRqType.getAdminType());
			}
		} catch (DataIntegrityViolationException ex) {
			throw new BusinessException(StatusEnum.EMAIL_ALREADY_USED);
		}

		if (createdAdmin == null) {
			throw new BusinessException(StatusEnum.ERROR_REGISTERING_ADMIN);
		}

		RegisterRsType registerRs = new RegisterRsType();
		registerRs.setStatus(StatusEnum.SUCCESS);
		registerRs.setAdminType(createdAdmin);

		return registerRs;
	}

	@Override
	public CheckNotificationRsType checkNotification(String email) throws BusinessException {
		AdminType admin = adminDao.findByEmail(email);

		if (admin == null) {
			throw new BusinessException(StatusEnum.ADMIN_NOT_FOUND);
		}

		CheckNotificationRsType checkNotificationRsType = new CheckNotificationRsType();
		checkNotificationRsType.setNotifications(admin.getNotifications());
		checkNotificationRsType.setStatus(StatusEnum.SUCCESS);
		return checkNotificationRsType;
	}

}
