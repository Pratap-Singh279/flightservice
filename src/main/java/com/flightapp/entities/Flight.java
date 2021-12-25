package com.flightapp.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Flight {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int flightId;
private String airlineName;
private String fromLoc;
private String toLoc;
private double price;
private LocalDateTime arrivalTime;
private LocalDateTime departTime;
private int totalAvlBusClSeats;
private int totalAvlNonBusClSeats;
private String airlineStatus;
public int getFlightId() {
	return flightId;
}
public void setFlightId(int flightId) {
	this.flightId = flightId;
}
public String getAirlineName() {
	return airlineName;
}
public void setAirlineName(String airlineName) {
	this.airlineName = airlineName;
}
public String getFromLoc() {
	return fromLoc;
}
public void setFromLoc(String fromLoc) {
	this.fromLoc = fromLoc;
}
public String getToLoc() {
	return toLoc;
}
public void setToLoc(String toLoc) {
	this.toLoc = toLoc;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public LocalDateTime getArrivalTime() {
	return arrivalTime;
}
public void setArrivalTime(LocalDateTime arrivalTime) {
	this.arrivalTime = arrivalTime;
}
public LocalDateTime getDepartTime() {
	return departTime;
}
public void setDepartTime(LocalDateTime departTime) {
	this.departTime = departTime;
}
public int getTotalSeats() {
	return totalSeats;
}
public void setTotalSeats(int totalSeats) {
	this.totalSeats = totalSeats;
}
public int getAvlBusClSeats() {
	return avlBusClSeats;
}
public void setAvlBusClSeats(int avlBusClSeats) {
	this.avlBusClSeats = avlBusClSeats;
}
public int getAvlNonBusClSeats() {
	return avlNonBusClSeats;
}
public void setAvlNonBusClSeats(int avlNonBusClSeats) {
	this.avlNonBusClSeats = avlNonBusClSeats;
}
public String getAirlineStatus() {
	return airlineStatus;
}
public void setAirlineStatus(String airlineStatus) {
	this.airlineStatus = airlineStatus;
}
@Override
public String toString() {
	return "Flight [flightId=" + flightId + ", airlineId=" + airlineId + ", airlineName=" + airlineName + ", fromLoc="
			+ fromLoc + ", toLoc=" + toLoc + ", price=" + price + ", arrivalTime=" + arrivalTime + ", departTime="
			+ departTime + ", totalSeats=" + totalSeats + ", avlBusClSeats=" + avlBusClSeats + ", avlNonBusClSeats="
			+ avlNonBusClSeats + ", airlineStatus=" + airlineStatus + "]";
}

}
