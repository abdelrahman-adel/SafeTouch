package com.safetouch.common.helpers.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetouch.api.interfaces.ILocation;
import com.safetouch.api.models.StatusEnum;
import com.safetouch.common.helpers.LocationHelper;
import com.safetouch.common.helpers.NotificationHelper;
import com.safetouch.dal.daos.AdminDao;
import com.safetouch.dal.entities.Admin;
import com.safetouch.exceptions.BusinessException;

@Service
public class NotificationHelperImpl implements NotificationHelper {

	private static final Logger LOGGER = LoggerFactory.getLogger(NotificationHelperImpl.class);

	@Autowired
	private AdminDao adminDao;

	@Autowired
	private LocationHelper locationHelper;

	@Override
	public Admin findNearestAdmin(ILocation location) throws BusinessException {
		List<Admin> admins = adminDao.findAll();
		if (admins == null || admins.isEmpty()) {
			throw new BusinessException(StatusEnum.SYSTEM_HAS_NO_ADMINS);
		}
		Map<Double, Admin> adminDistances = new HashMap<>();

		Double[] minDistance = { Double.MAX_VALUE };
		admins.stream().forEach(admin -> {
			double distance = locationHelper.distance(location, admin.getLocation());
			LOGGER.debug("distance for {} is: {}", admin, distance);
			adminDistances.put(distance, admin);
			if (minDistance[0] > distance) {
				LOGGER.debug("new minimum: {}", distance);
				minDistance[0] = distance;
			}
		});

		LOGGER.debug("will return: {}", adminDistances.get(minDistance[0]));
		return adminDistances.get(minDistance[0]);
	}

}
