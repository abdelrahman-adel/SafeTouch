package com.safetouch.api.service.response;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.safetouch.api.models.NotificationType;

public class CheckNotificationRsType extends BaseResponse {

	@JsonProperty("notifications")
	private List<NotificationType> notifications;

	public List<NotificationType> getNotifications() {
		if (notifications == null) {
			notifications = new ArrayList<>();
		}
		return notifications;
	}

	public void setNotifications(List<NotificationType> notifications) {
		this.notifications = notifications;
	}
}
