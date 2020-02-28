package com.safetouch.dal.daos;

import com.safetouch.api.models.UserType;

public interface UserDao {

	public UserType findByEmailAndPassword(String email, String password);

	public UserType findByEmail(String email);

	public UserType createUser(UserType userType);
}
