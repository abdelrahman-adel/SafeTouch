package com.safetouch.api.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserType {

	private Long id;
	private String fullName;
	private String address;
	private String email;
	private String password;
	private String gender;
	private String profilePic;
	private List<RelativeType> relatives;
	private List<DiseaseType> diseases;
	private Date birthDate;
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
