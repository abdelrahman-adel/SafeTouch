package com.safetouch.api.service.request;

import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReactToNotificationRqType {

	@JsonProperty("notifId")
	private BigInteger notifId;

	@JsonProperty("reaction")
	private boolean reaction;

	public BigInteger getNotifId() {
		return notifId;
	}

	public void setNotifId(BigInteger notifId) {
		this.notifId = notifId;
	}

	public boolean isReaction() {
		return reaction;
	}

	public void setReaction(boolean reaction) {
		this.reaction = reaction;
	}
}
