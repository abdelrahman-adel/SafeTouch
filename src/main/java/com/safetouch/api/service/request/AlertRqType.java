package com.safetouch.api.service.request;

import com.safetouch.api.models.Location;

public class AlertRqType {

	private String email;
	private Location location;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}
