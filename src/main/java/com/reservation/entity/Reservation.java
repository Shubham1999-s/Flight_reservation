package com.reservation.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Reservation extends AbstractEntity{
	private boolean checkedIn;
	private int numberOfbags;
	@OneToOne
	private Passenger passenger;
	@OneToOne
	private Flight flight;
	public boolean isCheckedIn() {
		return checkedIn;
	}
	public void setCheckedIn(boolean checkedIn) {
		this.checkedIn = checkedIn;
	}
	public int getNumberOfbags() {
		return numberOfbags;
	}
	public void setNumberOfbags(int numberOfbags) {
		this.numberOfbags = numberOfbags;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	 
	

}
