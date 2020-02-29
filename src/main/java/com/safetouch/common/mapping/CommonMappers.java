package com.safetouch.common.mapping;

import com.safetouch.api.models.LocationType;
import com.safetouch.api.models.UserType;
import com.safetouch.dal.entities.Location;
import com.safetouch.dal.entities.User;

public interface CommonMappers {

	UserType mapUserToUserType(User user, boolean includePassword);

	User mapUserInfoToHuman(UserType userType);

	LocationType mapLocationToLocationType(Location location);
}
