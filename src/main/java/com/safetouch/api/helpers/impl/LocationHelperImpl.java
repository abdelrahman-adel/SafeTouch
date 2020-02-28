package com.safetouch.api.helpers.impl;

import org.springframework.stereotype.Service;

import com.safetouch.api.helpers.LocationHelper;
import com.safetouch.api.models.Location;

@Service
public class LocationHelperImpl implements LocationHelper {

	@Override
	public double distance(Location point1, Location point2) {

		double distanceLat = Math.toRadians(point2.getLatitude() - point1.getLatitude());
		double distanceLong = Math.toRadians(point2.getLongitude() - point1.getLongitude());

		double sindLat = Math.sin(distanceLat / 2);
		double sindLng = Math.sin(distanceLong / 2);

		double a = Math.pow(sindLat, 2) + Math.pow(sindLng, 2) * Math.cos(Math.toRadians(point1.getLatitude()))
				* Math.cos(Math.toRadians(point2.getLatitude()));

		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		double distance = EARTH_RADIUS_K * c;

		return distance; // output distance, in MILES
	}

}
