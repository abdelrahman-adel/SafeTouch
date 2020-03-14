package com.safetouch.api.service.impl;

import java.math.BigInteger;

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
import com.safetouch.api.service.response.CheckCaseRsType;
import com.safetouch.api.service.response.FindRsType;
import com.safetouch.api.service.response.LoginRsType;
import com.safetouch.api.service.response.RegisterRsType;
import com.safetouch.dal.daos.NotificationDao;
import com.safetouch.dal.daos.UserDao;
import com.safetouch.dal.entities.Notification;
import com.safetouch.dal.entities.User;
import com.safetouch.exceptions.BusinessException;
import com.safetouch.exceptions.SystemException;

@Service
public class UserManagementServiceImpl implements UserManagementService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserManagementServiceImpl.class);

	@Autowired
	private UserDao userDao;

	@Autowired
	private NotificationDao notificationDao;

	@Override
	public LoginRsType login(LoginRqType loginInfo) throws BusinessException {
		UserType user = userDao.findUserTypeByEmailAndPassword(loginInfo.getEmail(), loginInfo.getPassword());

		if (user == null) {
			throw new BusinessException(StatusEnum.INVALID_CREDS);
		}

		LoginRsType loginRs = new LoginRsType();
		loginRs.setStatus(StatusEnum.SUCCESS);
		loginRs.setUserType(user);
		return loginRs;
	}

	@Override
	public RegisterRsType register(RegisterRqType registerRqType) throws BusinessException {
		UserType createdUser = null;

		try {
			if (registerRqType != null && registerRqType.getUserType() != null) {
				createdUser = userDao.createUser(registerRqType.getUserType());
			}
		} catch (DataIntegrityViolationException ex) {
			throw new BusinessException(StatusEnum.EMAIL_ALREADY_USED);
		}

		if (createdUser == null) {
			throw new BusinessException(StatusEnum.ERROR_REGISTERING_USER);
		}

		RegisterRsType registerRs = new RegisterRsType();
		registerRs.setStatus(StatusEnum.SUCCESS);
		registerRs.setUserType(createdUser);
		return registerRs;
	}

	@Override
	public FindRsType find(String email) throws BusinessException {
		if (email == null || email.isEmpty()) {
			throw new BusinessException(StatusEnum.BAD_REQUEST);
		}
		UserType userType = userDao.findUserTypeByEmail(email);

		if (userType == null) {
			throw new BusinessException(StatusEnum.USER_NOT_FOUND);
		}

		FindRsType findRs = new FindRsType();
		findRs.setStatus(StatusEnum.SUCCESS);
		findRs.setUserType(userType);
		return findRs;
	}

	@Override
	public AlertRsType alert(AlertRqType alertRqType) throws BusinessException {
		User user = userDao.findByEmail(alertRqType.getEmail());

		AlertRsType alertRs = new AlertRsType();
		if (user == null) {
			throw new BusinessException(StatusEnum.USER_NOT_FOUND);
		}

		Notification notif = notificationDao.createNotification(user, alertRqType.getLocationType());
		if (notif != null) {
			alertRs.setCaseNumber(notif.getId());
		}

		alertRs.setStatus(StatusEnum.SUCCESS);
		return alertRs;
	}

	@Override
	public CheckCaseRsType checkCase(String caseNumber) throws BusinessException {
		Boolean reacted = notificationDao.isReacted(new BigInteger(caseNumber));

		CheckCaseRsType checkCaseRsType = new CheckCaseRsType();
		if (reacted == null) {
			checkCaseRsType.setStatus(StatusEnum.NO_REACTION_YET);
		} else {
			checkCaseRsType.setStatus(reacted ? StatusEnum.SUCCESS : StatusEnum.CASE_HAS_BEEN_IGNORED);
		}
		return checkCaseRsType;
	}
}
