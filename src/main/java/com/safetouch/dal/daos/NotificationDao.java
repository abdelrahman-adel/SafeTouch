package com.safetouch.dal.daos;

import java.math.BigInteger;
import java.util.List;

import com.safetouch.api.interfaces.ILocation;
import com.safetouch.api.models.NotificationType;
import com.safetouch.dal.entities.Notification;
import com.safetouch.dal.entities.User;
import com.safetouch.exceptions.BusinessException;

public interface NotificationDao {

	Boolean updateNotificationState(BigInteger id, boolean notified);

	Notification createNotification(User user, ILocation location) throws BusinessException;

	List<NotificationType> findByAdminEmail(String email);

	Boolean isReacted(BigInteger id);
}
