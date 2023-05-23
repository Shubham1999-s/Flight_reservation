package com.reservation.dto;

public class ReservationUpdateRequest {
	private long id;
    private boolean checkedIn;
    private int numberOfbags;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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

}
