package com.safetouch.api.service.request;

import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReactToNotificationRqType {

	@JsonProperty("notifId")
	private BigInteger notifId;

	@JsonProperty("reaction")
	private Boolean reaction;

	public BigInteger getNotifId() {
		return notifId;
	}

	public void setNotifId(BigInteger notifId) {
		this.notifId = notifId;
	}

	public void setReaction(Boolean reaction) {
		this.reaction = reaction;
	}

	public Boolean getReaction() {
		return reaction;
	}
}
