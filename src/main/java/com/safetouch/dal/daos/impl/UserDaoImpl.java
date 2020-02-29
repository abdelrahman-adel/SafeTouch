package com.safetouch.dal.daos.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.safetouch.api.models.UserType;
import com.safetouch.common.mapping.CommonMappers;
import com.safetouch.dal.daos.UserDao;
import com.safetouch.dal.entities.User;
import com.safetouch.dal.repositories.UserRepository;

@Repository
public class UserDaoImpl implements UserDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CommonMappers commonMappers;

	@Override
	public UserType findUserTypeByEmailAndPassword(String email, String password) {
		User user = userRepository.findByEmailAndPassword(email, password);
		return commonMappers.mapUserToUserType(user, false);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public UserType findUserTypeByEmail(String email) {
		User user = userRepository.findByEmail(email);
		return commonMappers.mapUserToUserType(user, false);
	}

	@Override
	public UserType createUser(UserType userType) {
		User user = commonMappers.mapUserInfoToHuman(userType);
		user = userRepository.save(user);
		return commonMappers.mapUserToUserType(user, false);
	}
}
