package com.safetouch.api.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.safetouch.api.models.AdminType;
import com.safetouch.api.models.NotificationType;
import com.safetouch.api.models.StatusEnum;
import com.safetouch.api.service.AdminManagementService;
import com.safetouch.api.service.request.LoginRqType;
import com.safetouch.api.service.request.ReactToNotificationRqType;
import com.safetouch.api.service.request.RegisterRqType;
import com.safetouch.api.service.response.CheckNotificationRsType;
import com.safetouch.api.service.response.LoginRsType;
import com.safetouch.api.service.response.ReactToNotificationRsType;
import com.safetouch.api.service.response.RegisterRsType;
import com.safetouch.dal.daos.AdminDao;
import com.safetouch.dal.daos.NotificationDao;
import com.safetouch.exceptions.BusinessException;

@Service
public class AdminManagementServiceImpl implements AdminManagementService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AdminManagementServiceImpl.class);

	@Autowired
	private AdminDao adminDao;

	@Autowired
	private NotificationDao notificationDao;

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
	public CheckNotificationRsType checkNotifications(String email) throws BusinessException {
		List<NotificationType> notifications = notificationDao.findByAdminEmail(email);

		if (notifications == null || notifications.isEmpty()) {
			throw new BusinessException(StatusEnum.NO_NOTIFICATIONS_FOUND);
		}

		CheckNotificationRsType checkNotificationRsType = new CheckNotificationRsType();
		checkNotificationRsType.setNotifications(notifications);
		checkNotificationRsType.setStatus(StatusEnum.SUCCESS);
		LOGGER.debug("{}", checkNotificationRsType);
		return checkNotificationRsType;
	}

	@Override
	public ReactToNotificationRsType reactToNotification(ReactToNotificationRqType notificationRqType) throws BusinessException {
		if (notificationRqType == null || notificationRqType.getNotifId() == null || notificationRqType.getReaction() == null) {
			throw new BusinessException(StatusEnum.BAD_REQUEST);
		}

		ReactToNotificationRsType reactToNotificationRsType = new ReactToNotificationRsType();
		Boolean updateNotificationState = notificationDao.updateNotificationState(notificationRqType.getNotifId(), notificationRqType.getReaction());
		if (updateNotificationState == null) {
			throw new BusinessException(StatusEnum.NO_SUCH_NOTIFICATION);
		}
		if (!updateNotificationState) {
			throw new BusinessException(StatusEnum.NOTIFICATION_UPDATE_FAILED);
		}

		reactToNotificationRsType.setStatus(StatusEnum.SUCCESS);
		return reactToNotificationRsType;
	}

}
