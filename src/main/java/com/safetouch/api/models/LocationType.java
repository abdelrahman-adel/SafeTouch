package com.safetouch.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.safetouch.api.interfaces.ILocation;

public class LocationType implements ILocation {

	@JsonProperty("longitude")
	private Double longitude;

	@JsonProperty("latitude")
	private Double latitude;

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
}
