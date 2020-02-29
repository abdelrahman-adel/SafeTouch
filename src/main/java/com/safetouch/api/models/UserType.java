package com.safetouch.api.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserType {

	@JsonProperty("id")
	private Long id;

	@JsonProperty("fullName")
	private String fullName;

	@JsonProperty("address")
	private String address;

	@JsonProperty("email")
	private String email;

	@JsonProperty("password")
	private String password;

	@JsonProperty("gender")
	private String gender;

	@JsonProperty("profilePic")
	private String profilePic;

	@JsonProperty("relatives")
	private List<RelativeType> relatives;

	@JsonProperty("diseases")
	private List<DiseaseType> diseases;

	@JsonProperty("birthDate")
	private Date birthDate;

	@JsonProperty("bloodType")
	private String bloodType;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<DiseaseType> getDiseases() {
		if (diseases == null) {
			diseases = new ArrayList<>();
		}
		return diseases;
	}

	public List<RelativeType> getRelatives() {
		if (relatives == null) {
			relatives = new ArrayList<>();
		}
		return relatives;
	}

}
