package com.safetouch.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safetouch.dal.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmailAndPassword(String email, String password);

	User findByEmail(String email);
}
