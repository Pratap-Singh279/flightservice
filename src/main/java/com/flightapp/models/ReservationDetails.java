package com.flightapp.models;

import java.util.Date;

public class ReservationDetails {
	private String email;
	private int numberOfSeats;
	private Date resrvDate;
	private PassengerDetails[] passengersDetails;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	public Date getResrvDate() {
		return resrvDate;
	}
	public void setResrvDate(Date resrvDate) {
		this.resrvDate = resrvDate;
	}
	public PassengerDetails[] getPassengersDetails() {
		return passengersDetails;
	}
	public void setPassengersDetails(PassengerDetails[] passengersDetails) {
		this.passengersDetails = passengersDetails;
	}
}
