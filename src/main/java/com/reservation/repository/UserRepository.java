package com.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reservation.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String emailId);

}
