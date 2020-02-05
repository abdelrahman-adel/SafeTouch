package com.safetouch.dal.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.safetouch.dal.entities.Human;
import com.safetouch.dal.repositories.HumanRepository;
import com.safetouch.models.UserInfo;

@Repository
public class HumanDao {

	@Autowired
	HumanRepository humanRepository;

	public Human findByEmailAndPassword(String email, String password) {
		return humanRepository.findByEmailAndPassword(email, password);
	}

	public Human findByEmail(String email) {
		return humanRepository.findByEmail(email);
	}

	public Human createUser(UserInfo userInfo) {
		Human user = new Human();
		user.setFullName(userInfo.getFullName());
		user.setAddress(userInfo.getAddress());
		// user.setBirthDate(userInfo.getBirthDate());
		user.setBloodType(userInfo.getBloodType());
		user.setEmail(userInfo.getEmail());
		user.setPassword(userInfo.getPassword());
		user.setGender(userInfo.getGender());
		user.setProfilePic(userInfo.getProfilePic());
		// user.setRelatives(relatives);
		// user.setDiseases(diseases);
		return humanRepository.save(user);
	}

}
