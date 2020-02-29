package com.safetouch.helpers;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.safetouch.api.models.LocationType;
import com.safetouch.dal.daos.AdminDao;
import com.safetouch.dal.entities.Admin;
import com.safetouch.dal.entities.Location;
import com.safetouch.exceptions.BusinessException;

@SpringBootTest
class NotificationHelperTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(NotificationHelperTest.class);

	@Autowired
	private NotificationHelper notificationHelper;

	@MockBean
	private AdminDao adminDao;

	@BeforeEach
	private void setUp() {
		List<Admin> admins = getDummyAdmins();
		when(adminDao.findAll()).thenReturn(admins);
	}

	@Test
	void test() throws BusinessException {
		LocationType location = new LocationType();
		location.setLongitude(9999.9999);
		location.setLatitude(9993.9993);
		Admin nearestAdmin = notificationHelper.findNearestAdmin(location);
		LOGGER.debug("{}", nearestAdmin);
		assertNotNull(nearestAdmin);
		assertNotNull(nearestAdmin.getId());
	}

	private List<Admin> getDummyAdmins() {
		List<Admin> admins = new ArrayList<>();
		Admin admin = new Admin();
		admin.setId(1l);
		admin.setEntityName("El7omyat");
		admin.setAddress("ay 7eta");
		admin.setEmail("el7omyat@egypt.com");
		admin.setPassword("hahaha");
		Location location = new Location();
		location.setLatitude(21.1233);
		location.setLongitude(35.1233);
		admin.setLocation(location);
		admins.add(admin);
		admin = new Admin();
		admin.setId(2l);
		admin.setEntityName("Elm3adi El3askry");
		admin.setAddress("ay 7eta fe elm3ady");
		admin.setEmail("elm3ady@egypt.com");
		admin.setPassword("heheheeee");
		location = new Location();
		location.setLatitude(67.8377);
		location.setLongitude(98.88);
		admin.setLocation(location);
		admins.add(admin);

		return admins;
	}

}
