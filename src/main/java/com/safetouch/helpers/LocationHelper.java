package com.safetouch.helpers;

import com.safetouch.api.interfaces.ILocation;

public interface LocationHelper {

	double EARTH_RADIUS_M = 3958.75;
	double EARTH_RADIUS_K = 6371;

	double distance(ILocation point1, ILocation point2);
}
