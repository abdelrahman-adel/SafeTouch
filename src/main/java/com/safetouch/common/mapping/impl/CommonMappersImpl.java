package com.safetouch.common.mapping.impl;

import java.util.ArrayList;
import java.util.List;

import com.safetouch.api.models.DiseaseType;
import com.safetouch.api.models.LocationType;
import com.safetouch.api.models.RelativeType;
import com.safetouch.api.models.UserType;
import com.safetouch.common.mapping.CommonMappers;
import com.safetouch.dal.entities.Disease;
import com.safetouch.dal.entities.Location;
import com.safetouch.dal.entities.Relative;
import com.safetouch.dal.entities.User;

public class CommonMappersImpl implements CommonMappers {

	@Override
	public UserType mapUserToUserType(User user, boolean includePassword) {
		if (user != null) {
			UserType userType = new UserType();
			userType.setId(user.getId());
			userType.setFullName(user.getFullName());
			userType.setAddress(user.getAddress());
			userType.setBirthDate(user.getBirthDate());
			userType.setBloodType(user.getBloodType());

			for (Disease disease : user.getDiseases()) {
				DiseaseType diseaseType = new DiseaseType();
				diseaseType.setId(disease.getId());
				diseaseType.setName(disease.getName());
				userType.getDiseases().add(diseaseType);
			}

			userType.setEmail(user.getEmail());
			userType.setGender(user.getGender());
			if (includePassword) {
				userType.setPassword(user.getPassword());
			}
			userType.setProfilePic(user.getProfilePic());

			for (Relative relative : user.getRelatives()) {
				RelativeType relativeType = new RelativeType();
				relativeType.setId(relative.getId());
				relativeType.setName(relative.getName());
				relativeType.setMobile(relative.getMobile());
				userType.getRelatives().add(relativeType);
			}
			return userType;
		} else {
			return null;
		}
	}

	@Override
	public User mapUserInfoToHuman(UserType userType) {
		if (userType != null) {
			User user = new User();
			user.setId(userType.getId());
			user.setFullName(userType.getFullName());
			user.setAddress(userType.getAddress());
			user.setBirthDate(userType.getBirthDate());
			user.setBloodType(userType.getBloodType());

			List<Disease> diseases = new ArrayList<>();
			user.setDiseases(diseases);
			for (DiseaseType diseaseType : userType.getDiseases()) {
				Disease disease = new Disease();
				if (diseaseType.getId() != null) {
					disease.setId(diseaseType.getId());
				}
				disease.setName(diseaseType.getName());
				user.getDiseases().add(disease);
			}

			user.setEmail(userType.getEmail());
			user.setGender(userType.getGender());
			user.setPassword(userType.getPassword());
			user.setProfilePic(userType.getProfilePic());

			List<Relative> relatives = new ArrayList<>();
			user.setRelatives(relatives);
			for (RelativeType relativeType : userType.getRelatives()) {
				Relative relative = new Relative();
				relative.setHuman(user);
				if (relativeType.getId() != null) {
					relative.setId(relativeType.getId());
				}
				relative.setName(relativeType.getName());
				relative.setMobile(relativeType.getMobile());
				user.getRelatives().add(relative);
			}
			return user;
		} else {
			return null;
		}
	}

	@Override
	public LocationType mapLocationToLocationType(Location location) {
		LocationType locationType = new LocationType();
		locationType.setLatitude(location.getLatitude());
		locationType.setLongitude(location.getLongitude());
		return locationType;
	}
}
