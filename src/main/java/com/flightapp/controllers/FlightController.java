package com.flightapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.entities.Flight;
import com.flightapp.entities.Reservation;
import com.flightapp.models.ReservationDetails;
import com.flightapp.models.SearchFlight;
import com.flightapp.services.FlightService;

@RestController
@RequestMapping("/flight")
public class FlightController {

	@Autowired
	FlightService fltService;

	@PostMapping("/search")
	public List<Flight> searchFlight(@RequestBody SearchFlight srchFlight) {
		return fltService.searchFlight(srchFlight);
	}

	@PostMapping("/airline/register")
	public String registerFlight(@RequestBody Flight flight) {
		return fltService.registerFlight(flight);
	}

	@PutMapping("/airline/inventory/add")
	public String addInventory(@RequestBody Flight flight) {
		return fltService.updateFlight(flight);
	}
	
	@PostMapping("/booking/{flightid}")
	public String bookingFlight(@PathVariable("flightid") Integer flightId,@RequestBody ReservationDetails reservationDetails ) {
		return fltService.bookingTicket(flightId,reservationDetails);
	}
	
	@GetMapping("/ticket/{pnr}")
	public Reservation getTicket(@PathVariable("pnr") int pnr) {
		return fltService.getTicketDetails(pnr);
	}
	
}
