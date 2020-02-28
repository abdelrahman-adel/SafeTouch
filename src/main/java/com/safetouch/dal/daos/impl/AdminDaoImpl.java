package com.safetouch.dal.daos.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.safetouch.api.models.AdminType;
import com.safetouch.dal.daos.AdminDao;
import com.safetouch.dal.entities.Admin;
import com.safetouch.dal.repositories.AdminRepository;

@Repository
public class AdminDaoImpl implements AdminDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(AdminDaoImpl.class);

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public AdminType findByEmailAndPassword(String email, String password) {
		Admin admin = adminRepository.findByEmailAndPassword(email, password);
		return mapUserToUserType(admin, false);
	}

	@Override
	public AdminType createAdmin(AdminType adminType) {
		Admin admin = mapUserInfoToHuman(adminType);
		admin = adminRepository.save(admin);
		return mapUserToUserType(admin, false);
	}

	private AdminType mapUserToUserType(Admin admin, boolean includePassword) {
		if (admin != null) {
			AdminType adminType = new AdminType();
			adminType.setId(admin.getId());
			adminType.setEntityName(admin.getEntityName());
			adminType.setAddress(admin.getAddress());
			adminType.setEmail(admin.getEmail());
			if (includePassword) {
				adminType.setPassword(admin.getPassword());
			}
			return adminType;
		} else {
			return null;
		}
	}

	private Admin mapUserInfoToHuman(AdminType adminType) {
		if (adminType != null) {
			Admin admin = new Admin();
			admin.setId(adminType.getId());
			admin.setEntityName(adminType.getEntityName());
			admin.setAddress(adminType.getAddress());
			admin.setEmail(adminType.getEmail());
			admin.setPassword(adminType.getPassword());
			return admin;
		} else {
			return null;
		}
	}

}
