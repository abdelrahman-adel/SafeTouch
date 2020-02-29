package com.safetouch.api.service.response;

import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AlertRsType extends BaseResponse {

	@JsonProperty("caseNumber")
	private BigInteger caseNumber;

	public BigInteger getCaseNumber() {
		return caseNumber;
	}

	public void setCaseNumber(BigInteger caseNumber) {
		this.caseNumber = caseNumber;
	}
}
