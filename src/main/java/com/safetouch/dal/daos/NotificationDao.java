package com.safetouch.dal.daos;

import com.safetouch.api.interfaces.ILocation;
import com.safetouch.dal.entities.Notification;
import com.safetouch.dal.entities.User;
import com.safetouch.exceptions.BusinessException;

public interface NotificationDao {

	Notification createNotification(User user, ILocation location) throws BusinessException;
}
