package com.safetouch.common.mapping.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.safetouch.api.models.AdminType;
import com.safetouch.api.models.DiseaseType;
import com.safetouch.api.models.LocationType;
import com.safetouch.api.models.NotificationType;
import com.safetouch.api.models.RelativeType;
import com.safetouch.api.models.UserType;
import com.safetouch.common.mapping.CommonMappers;
import com.safetouch.dal.entities.Admin;
import com.safetouch.dal.entities.Disease;
import com.safetouch.dal.entities.Location;
import com.safetouch.dal.entities.Notification;
import com.safetouch.dal.entities.Relative;
import com.safetouch.dal.entities.User;

@Service
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
	public User mapUserTypeToUser(UserType userType) {
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

	@Override
	public Location mapLocationTypeToLocation(LocationType locationType) {
		Location location = new Location();
		location.setLatitude(locationType.getLatitude());
		location.setLongitude(locationType.getLongitude());
		return location;
	}

	@Override
	public NotificationType mapNotificationToNotificationType(Notification notification, AdminType adminType, UserType userType) {
		NotificationType notificationType = new NotificationType();
		notificationType.setId(notification.getId());
		notificationType.setLocationType(this.mapLocationToLocationType(notification.getLocation()));
		notificationType.setAdminType(adminType);
		notificationType.setUserType(userType);
		return notificationType;
	}

	@Override
	public Notification mapNotificationTypeToNotification(NotificationType notificationType, Admin admin, User user) {
		Notification notification = new Notification();
		notification.setId(notificationType.getId());
		notification.setLocation(this.mapLocationTypeToLocation(notificationType.getLocationType()));
		notification.setAdmin(admin);
		notification.setUser(user);
		return notification;
	}
}
