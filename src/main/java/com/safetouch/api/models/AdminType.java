package com.safetouch.api.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AdminType {

	@JsonProperty("id")
	private Long id;

	@JsonProperty("entityName")
	private String entityName;

	@JsonProperty("address")
	private String address;

	@JsonProperty("email")
	private String email;

	@JsonProperty("password")
	private String password;

	@JsonProperty("notifications")
	private List<NotificationType> notifications;

	@JsonProperty("location")
	private LocationType locationType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<NotificationType> getNotifications() {
		if (notifications == null) {
			notifications = new ArrayList<>();
		}
		return notifications;
	}

	public void setNotifications(List<NotificationType> notifications) {
		this.notifications = notifications;
	}

	public LocationType getLocationType() {
		return locationType;
	}

	public void setLocationType(LocationType locationType) {
		this.locationType = locationType;
	}
}
