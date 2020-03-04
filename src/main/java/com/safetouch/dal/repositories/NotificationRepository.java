package com.safetouch.dal.repositories;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safetouch.dal.entities.Notification;

public interface NotificationRepository extends JpaRepository<Notification, BigInteger> {

	List<Notification> findByNotifiedAndAdminEmail(Boolean notified, String email);

}
