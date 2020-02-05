package com.safetouch.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safetouch.dal.entities.Human;

public interface HumanRepository extends JpaRepository<Human, Long> {

	Human findByEmailAndPassword(String email, String password);

	Human findByEmail(String email);
}
