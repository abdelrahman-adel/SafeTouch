package com.safetouch.api.models;

import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NotificationType {

	@JsonProperty("id")
	private BigInteger id;

	@JsonProperty("location")
	private LocationType locationType;

	@JsonProperty("admin")
	private AdminType adminType;

	@JsonProperty("user")
	private UserType userType;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public LocationType getLocationType() {
		return locationType;
	}

	public void setLocationType(LocationType locationType) {
		this.locationType = locationType;
	}

	public AdminType getAdminType() {
		return adminType;
	}

	public void setAdminType(AdminType adminType) {
		this.adminType = adminType;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}
}
