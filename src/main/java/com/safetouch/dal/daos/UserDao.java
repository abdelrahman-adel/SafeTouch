package com.safetouch.dal.daos;

import com.safetouch.api.models.UserType;
import com.safetouch.dal.entities.User;

public interface UserDao {

	UserType findUserTypeByEmailAndPassword(String email, String password);

	UserType findUserTypeByEmail(String email);

	User findByEmail(String email);

	UserType createUser(UserType userType);
}
