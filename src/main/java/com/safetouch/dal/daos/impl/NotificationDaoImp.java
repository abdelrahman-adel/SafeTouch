package com.safetouch.dal.daos.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.safetouch.api.interfaces.ILocation;
import com.safetouch.api.models.NotificationType;
import com.safetouch.common.mapping.CommonMappers;
import com.safetouch.dal.daos.AdminDao;
import com.safetouch.dal.daos.NotificationDao;
import com.safetouch.dal.entities.Admin;
import com.safetouch.dal.entities.Location;
import com.safetouch.dal.entities.Notification;
import com.safetouch.dal.entities.User;
import com.safetouch.dal.repositories.NotificationRepository;
import com.safetouch.exceptions.BusinessException;
import com.safetouch.helpers.NotificationHelper;

@Repository
public class NotificationDaoImp implements NotificationDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(NotificationDaoImp.class);

	@Autowired
	private NotificationRepository notificationRepository;

	@Autowired
	private NotificationHelper notificationHelper;

	@Autowired
	private AdminDao adminDao;

	@Autowired
	private CommonMappers commonMappers;

	@Override
	public Notification createNotification(User user, ILocation location) throws BusinessException {
		Admin admin = notificationHelper.findNearestAdmin(location);

		Notification notification = new Notification();
		notification.setAdmin(admin);
		notification.setUser(user);
		notification.setLocation(mapToLocation(location));

		if (admin.getNotifications() == null) {
			admin.setNotifications(new ArrayList<>());
		}
		admin.getNotifications().add(notification);
		adminDao.updateAdmin(admin);

		notification = notificationRepository.save(notification);
		return notification;
	}

	@Override
	public List<NotificationType> findByAdminEmail(String email) {
		List<Notification> notifications = notificationRepository.findByNotifiedAndAdminEmail(false, email);
		List<NotificationType> notificationTypes = new ArrayList<>();
		for (Notification notification : notifications) {
			notificationTypes.add(commonMappers.mapNotificationToNotificationType(notification, null, commonMappers.mapUserToUserType(notification.getUser(), false)));
		}
		return notificationTypes;
	}

	private Location mapToLocation(ILocation location) {
		Location newLocation = new Location();
		newLocation.setLongitude(location.getLongitude());
		newLocation.setLatitude(location.getLatitude());
		return newLocation;
	}

}
