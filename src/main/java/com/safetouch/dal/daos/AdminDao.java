package com.safetouch.dal.daos;

import com.safetouch.api.models.AdminType;

public interface AdminDao {

	public AdminType findByEmailAndPassword(String email, String password);

	public AdminType createAdmin(AdminType adminType);

}
