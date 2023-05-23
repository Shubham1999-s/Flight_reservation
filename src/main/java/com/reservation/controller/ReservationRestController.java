package com.reservation.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reservation.dto.ReservationUpdateRequest;
import com.reservation.entity.Reservation;
import com.reservation.repository.ReservationRepository;

@RestController
public class ReservationRestController {//This part of coding is Restful webservices
	@Autowired
	private ReservationRepository reservationRepo;
	@RequestMapping("/reservation/{id}")

	public Reservation findReservation(@PathVariable("id") long id) {
		Optional<Reservation> findById = reservationRepo.findById(id);
		Reservation reservation = findById.get();
		
		
		return reservation;
	}

	@RequestMapping("/reservation")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		Optional<Reservation> findById = reservationRepo.findById(request.getId());
		Reservation reservation = findById.get();
		reservation.setCheckedIn(request.isCheckedIn());
		reservation.setNumberOfbags(request.getNumberOfbags());
		return reservationRepo.save(reservation);

}
}
