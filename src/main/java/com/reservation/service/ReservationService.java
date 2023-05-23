package com.reservation.service;

import org.springframework.stereotype.Service;

import com.reservation.dto.ReservationRequest;
import com.reservation.entity.Reservation;
@Service
public interface ReservationService {
	Reservation bookFlight(ReservationRequest request);

}
