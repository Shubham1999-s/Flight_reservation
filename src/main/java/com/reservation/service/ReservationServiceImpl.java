package com.reservation.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservation.dto.ReservationRequest;
import com.reservation.entity.Flight;
import com.reservation.entity.Passenger;
import com.reservation.entity.Reservation;
import com.reservation.repository.FlightRepository;
import com.reservation.repository.PassengerRepository;
import com.reservation.repository.ReservationRepository;
import com.reservation.utilities.EmailSender;
import com.reservation.utilities.PDFgenerator;
@Service
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	private PassengerRepository passengerRepo;
	@Autowired
	private FlightRepository flightRepo;
	@Autowired
	private ReservationRepository reservationRepo;
	@Autowired
	private PDFgenerator pdfGenerator;
	@Autowired
	private EmailSender emailSender;

	@Override
	public Reservation bookFlight(ReservationRequest request) {
		 
		 
		 
		Passenger passenger=new Passenger();
		passenger.setFirstName(request.getFirstName());
		passenger.setLastName(request.getLastName());
		passenger.setMiddleName(request.getMiddleName());
		passenger.setEmail(request.getEmail());
		passenger.setPhone(request.getPhone());
		passengerRepo.save(passenger);
		long flightId = request.getFlightId();
		Optional<Flight> findById = flightRepo.findById(flightId);
		Flight flight = findById.get();
		Reservation reservation=new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(passenger);
		reservation.setCheckedIn(false);
		reservation.setNumberOfbags(0);
		String filePath="D:\\STSV4.17\\Flight_Reservation\\tickets"+reservation.getId()+".pdf";
		reservationRepo.save(reservation);
		 
		pdfGenerator.generateItinerary(reservation, filePath);
		emailSender.sendItinerary(passenger.getEmail(),filePath);
		return reservation;
	}

}
