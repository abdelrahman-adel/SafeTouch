package com.safetouch.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safetouch.dal.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

	Admin findByEmailAndPassword(String email, String password);

	Admin findByEmail(String email);
}
