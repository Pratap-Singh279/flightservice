package com.flightapp.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Reservation implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pnr;
	private int flightId;
	private String email;
	private int numberOfSeats;
	private Date resrvDate;
	@OneToMany( cascade = CascadeType.ALL)
	private Set<Passenger> passengers;

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

	public Set<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(Set<Passenger> passengers) {
		this.passengers = passengers;
	}

	public void addPassanger(Passenger passenger) {
		if (passenger != null) {
			if (passengers == null) {
				passengers = new HashSet<>();
			}
			passenger.setReserv(this);
			passengers.add(passenger);
		}
	}
}