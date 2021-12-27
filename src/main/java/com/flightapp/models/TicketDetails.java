package com.flightapp.models;

import java.io.Serializable;
import java.util.Date;

public class TicketDetails implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer pnr;
	private int flightId;
	private String email;
	private int numberOfSeats;
	private Date resrvDate;
	private PassengerDetails[] passengers;
	public Integer getPnr() {
		return pnr;
	}
	public void setPnr(Integer pnr) {
		this.pnr = pnr;
	}
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
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
	public PassengerDetails[] getPassengers() {
		return passengers;
	}
	public void setPassengers(PassengerDetails[] passengers) {
		this.passengers = passengers;
	}

}
