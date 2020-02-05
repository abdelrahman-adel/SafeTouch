package com.safetouch.api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetouch.api.models.LoginInfo;
import com.safetouch.api.models.StatusEnum;
import com.safetouch.api.models.UserInfo;
import com.safetouch.api.services.UserManagementService;
import com.safetouch.api.services.interfaces.UserInfoRs;
import com.safetouch.dal.daos.HumanDao;
import com.safetouch.dal.entities.Human;

@Service
public class UserManagementServiceImpl implements UserManagementService {

	@Autowired
	HumanDao humanDao;

	@Override
	public UserInfoRs login(LoginInfo loginInfo) {

		StatusEnum status = null;
		Human user = null;
		try {
			user = humanDao.findByEmailAndPassword(loginInfo.getEmail(), loginInfo.getPassword());

			if (user != null) {
				status = StatusEnum.SUCCESS;
			} else {
				status = StatusEnum.INVALID_CREDS;
			}
		} catch (Exception e) {
			status = StatusEnum.FAILURE;
		}

		UserInfoRs userInfoRs = new UserInfoRs();
		buildUserInfoRs(userInfoRs, user, status);

		return userInfoRs;
	}

	@Override
	public UserInfoRs register(UserInfo userInfo) {

		StatusEnum status = null;
		Human user = null;
		try {
			user = humanDao.createUser(userInfo);

			if (user != null) {
				status = StatusEnum.SUCCESS;
			} else {
				status = StatusEnum.ERROR_REGISTERING_USER;
			}
		} catch (Exception e) {
			status = StatusEnum.FAILURE;
		}

		UserInfoRs userInfoRs = new UserInfoRs();
		buildUserInfoRs(userInfoRs, user, status);

		return userInfoRs;
	}

	@Override
	public UserInfoRs find(String email) {

		StatusEnum status = null;
		Human user = null;
		try {
			user = humanDao.findByEmail(email);

			if (user != null) {
				status = StatusEnum.SUCCESS;
			} else {
				status = StatusEnum.USER_NOT_FOUND;
			}
		} catch (Exception e) {
			status = StatusEnum.FAILURE;
		}

		UserInfoRs userInfoRs = new UserInfoRs();
		buildUserInfoRs(userInfoRs, user, status);

		return userInfoRs;
	}

	private void buildUserInfoRs(UserInfoRs userInfoRs, Human user, StatusEnum status) {
		userInfoRs.setStatus(status);

		UserInfo userInfo = new UserInfo();
		userInfo.setFullName("Abdulrahman Adel");
		userInfo.setAddress("Abdulrahman Adel");
		userInfo.setBirthDate("Abdulrahman Adel");
		userInfo.setBloodType("Abdulrahman Adel");
		userInfo.setDeseases("Abdulrahman Adel");
		userInfo.setEmail("Abdulrahman Adel");
		userInfo.setGender("Abdulrahman Adel");
		userInfo.setProfilePic("Abdulrahman Adel");
		userInfo.setRelativesNums("Abdulrahman Adel");

		userInfoRs.setUserInfo(userInfo);
	}
}
