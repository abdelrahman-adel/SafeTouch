package com.safetouch.dal.daos;

import java.util.List;

import com.safetouch.api.models.AdminType;
import com.safetouch.dal.entities.Admin;

public interface AdminDao {

	AdminType findByEmailAndPassword(String email, String password);

	AdminType createAdmin(AdminType adminType);

	List<Admin> findAll();

	Admin updateAdmin(Admin admin);

	AdminType findByEmail(String email);

}
