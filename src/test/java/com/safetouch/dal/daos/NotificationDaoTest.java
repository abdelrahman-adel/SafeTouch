package com.safetouch.dal.daos;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetouch.api.models.NotificationType;

@SpringBootTest
class NotificationDaoTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(NotificationDaoTest.class);

	@Autowired
	private NotificationDao notificationDao;

	@Test
	void testFindByAdminEmail() {
		List<NotificationType> notificationTypes = notificationDao.findByAdminEmail("a@a.a");
		assertNotNull(notificationTypes);
		LOGGER.info("{}", notificationTypes);
	}

}
