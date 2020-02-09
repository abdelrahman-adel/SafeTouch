package com.safetouch.dal.daos;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.safetouch.api.models.DiseaseType;
import com.safetouch.api.models.RelativeType;
import com.safetouch.api.models.UserType;
import com.safetouch.dal.entities.Disease;
import com.safetouch.dal.entities.User;
import com.safetouch.dal.entities.Relative;
import com.safetouch.dal.repositories.UserRepository;

@Repository
public class UserDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserDao.class);

	@Autowired
	private UserRepository userRepository;

	public UserType findByEmailAndPassword(String email, String password) {
		User user = userRepository.findByEmailAndPassword(email, password);
		return mapUserToUserType(user, false);
	}

	public UserType findByEmail(String email) {
		User user = userRepository.findByEmail(email);
		return mapUserToUserType(user, false);
	}

	public UserType createUser(UserType userType) {
		User user = mapUserInfoToHuman(userType);
		user = userRepository.save(user);
		return mapUserToUserType(user, false);
	}

	private UserType mapUserToUserType(User user, boolean includePassword) {
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

	private User mapUserInfoToHuman(UserType userType) {
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

}
