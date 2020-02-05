package com.safetouch.api.models;

public class UserInfo {

	private String fullName;
	private String address;
	private String email;
	private String password;
	private String gender;
	private String profilePic;
	private String deseases;
	private String relativesNums;
	private String birthDate;
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

	public String getDeseases() {
		return deseases;
	}

	public void setDeseases(String deseases) {
		this.deseases = deseases;
	}

	public String getRelativesNums() {
		return relativesNums;
	}

	public void setRelativesNums(String relativesNums) {
		this.relativesNums = relativesNums;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
}
