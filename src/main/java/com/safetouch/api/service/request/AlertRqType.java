package com.safetouch.api.service.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.safetouch.api.models.LocationType;

public class AlertRqType {

	@JsonProperty("email")
	private String email;

	@JsonProperty("location")
	private LocationType locationType;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocationType getLocationType() {
		return locationType;
	}

	public void setLocationType(LocationType location) {
		this.locationType = location;
	}
}
