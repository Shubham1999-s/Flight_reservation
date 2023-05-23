package com.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reservation.dto.ReservationRequest;
import com.reservation.entity.Reservation;
import com.reservation.service.ReservationService;

@Controller
public class ReservationController {
	@Autowired
	private ReservationService reservationService;
	@RequestMapping("/confirmReservation")
	public String confirmreservation(ReservationRequest request,ModelMap modelMap) {
		Reservation reservationId = reservationService.bookFlight(request);
		modelMap.addAttribute("reservationId", reservationId.getId());
		 
		return"confirmReservation";
	}

}
