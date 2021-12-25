package com.flightapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.entities.Flight;
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
	
}
