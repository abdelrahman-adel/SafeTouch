package com.safetouch.common.mapping;

import com.safetouch.api.models.AdminType;
import com.safetouch.api.models.LocationType;
import com.safetouch.api.models.NotificationType;
import com.safetouch.api.models.UserType;
import com.safetouch.dal.entities.Admin;
import com.safetouch.dal.entities.Location;
import com.safetouch.dal.entities.Notification;
import com.safetouch.dal.entities.User;

public interface CommonMappers {

	UserType mapUserToUserType(User user, boolean includePassword);

	User mapUserTypeToUser(UserType userType);

	LocationType mapLocationToLocationType(Location location);

	NotificationType mapNotificationToNotificationType(Notification notification, AdminType adminType, UserType userType);

	Location mapLocationTypeToLocation(LocationType locationType);

	Notification mapNotificationTypeToNotification(NotificationType notificationType, Admin admin, User user);
}
