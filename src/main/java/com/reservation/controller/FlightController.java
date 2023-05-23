package com.reservation.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.reservation.entity.Flight;
import com.reservation.repository.FlightRepository;

@Controller
public class FlightController {
	@Autowired
	private FlightRepository flightRepo;
	@RequestMapping("/findflights")
	public String findFlights(@RequestParam("from") String from,@RequestParam("to") String to,
	@RequestParam("departureDate") @DateTimeFormat(pattern="MM-dd-yyyy") 
	Date departureDate, ModelMap modelMap ) {
		List<Flight> findFly = flightRepo.findFlights(from,to,departureDate);
	    modelMap.addAttribute("findFly", findFly);
		
		return"displayflights";
	}
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") long flightId, ModelMap modelMap) {
        Optional<Flight> findById = flightRepo.findById(flightId);
        Flight flight = findById.get();
        modelMap.addAttribute("flight", flight);
         
		return"showReservation";

}
}
