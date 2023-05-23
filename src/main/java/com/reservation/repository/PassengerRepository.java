package com.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reservation.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
