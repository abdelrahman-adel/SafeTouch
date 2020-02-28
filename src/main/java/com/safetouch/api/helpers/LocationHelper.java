package com.safetouch.api.helpers;

import com.safetouch.api.models.Location;

public interface LocationHelper {

	double EARTH_RADIUS_M = 3958.75;
	double EARTH_RADIUS_K = 6371;

	double distance(Location point1, Location point2);
}
