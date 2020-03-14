package com.safetouch.api.service.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.safetouch.api.models.LocationType;

public class AlertRqType {

	@NotBlank
	@JsonProperty("email")
	private String email;

	@NotNull
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
