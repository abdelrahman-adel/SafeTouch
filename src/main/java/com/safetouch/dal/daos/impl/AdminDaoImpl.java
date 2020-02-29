package com.safetouch.dal.daos.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.safetouch.api.models.AdminType;
import com.safetouch.api.models.NotificationType;
import com.safetouch.common.mapping.CommonMappers;
import com.safetouch.dal.daos.AdminDao;
import com.safetouch.dal.entities.Admin;
import com.safetouch.dal.entities.Notification;
import com.safetouch.dal.repositories.AdminRepository;

@Repository
public class AdminDaoImpl implements AdminDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(AdminDaoImpl.class);

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private CommonMappers commonMappers;

	@Override
	public List<Admin> findAll() {
		return adminRepository.findAll();
	}

	@Override
	public AdminType findByEmail(String email) {
		Admin admin = adminRepository.findByEmail(email);
		return mapAdminToAdminType(admin, false);
	}

	@Override
	public AdminType findByEmailAndPassword(String email, String password) {
		Admin admin = adminRepository.findByEmailAndPassword(email, password);
		return mapAdminToAdminType(admin, false);
	}

	@Override
	public AdminType createAdmin(AdminType adminType) {
		Admin admin = mapAdminTypeToAdmin(adminType);
		admin = adminRepository.save(admin);
		return mapAdminToAdminType(admin, false);
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	private AdminType mapAdminToAdminType(Admin admin, boolean includePassword) {
		if (admin != null) {
			AdminType adminType = new AdminType();
			adminType.setId(admin.getId());
			adminType.setEntityName(admin.getEntityName());
			adminType.setAddress(admin.getAddress());
			adminType.setEmail(admin.getEmail());
			if (includePassword) {
				adminType.setPassword(admin.getPassword());
			}
			/**
			 * NEW
			 */
			adminType.setLocationType(commonMappers.mapLocationToLocationType(admin.getLocation()));

			for (Notification notification : admin.getNotifications()) {
				NotificationType notificationType = new NotificationType();
				notificationType.setId(notification.getId());
				notificationType.setLocationType(commonMappers.mapLocationToLocationType(notification.getLocation()));
				notificationType.setAdminType(adminType);
				notificationType.setUserType(commonMappers.mapUserToUserType(notification.getUser(), false));
				adminType.getNotifications().add(notificationType);
			}

			return adminType;
		} else {
			return null;
		}
	}

	private Admin mapAdminTypeToAdmin(AdminType adminType) {
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
