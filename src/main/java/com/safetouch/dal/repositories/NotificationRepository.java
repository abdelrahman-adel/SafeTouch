package com.safetouch.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safetouch.dal.entities.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
