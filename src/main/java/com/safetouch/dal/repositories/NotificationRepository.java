package com.safetouch.dal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safetouch.dal.entities.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

	List<Notification> findByNotifiedAndAdminEmail(boolean notified, String email);

}
