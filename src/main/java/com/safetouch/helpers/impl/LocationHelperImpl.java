package com.safetouch.helpers.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.safetouch.api.interfaces.ILocation;
import com.safetouch.helpers.LocationHelper;

@Service
public class LocationHelperImpl implements LocationHelper {

	private static final Logger LOGGER = LoggerFactory.getLogger(LocationHelperImpl.class);

	@Override
	public double distance(ILocation point1, ILocation point2) {

		double distanceLat = Math.toRadians(point2.getLatitude() - point1.getLatitude());
		double distanceLong = Math.toRadians(point2.getLongitude() - point1.getLongitude());

		double sindLat = Math.sin(distanceLat / 2);
		double sindLng = Math.sin(distanceLong / 2);

		double a = Math.pow(sindLat, 2) + Math.pow(sindLng, 2) * Math.cos(Math.toRadians(point1.getLatitude())) * Math.cos(Math.toRadians(point2.getLatitude()));

		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		double distance = EARTH_RADIUS_K * c;

		return distance;
	}

}
