package com.safetouch.common.helpers;

import com.safetouch.api.interfaces.ILocation;
import com.safetouch.dal.entities.Admin;
import com.safetouch.exceptions.BusinessException;

public interface NotificationHelper {

	Admin findNearestAdmin(ILocation location) throws BusinessException;
}
