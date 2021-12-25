package com.flightapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.entities.Flight;
import com.flightapp.models.SearchFlight;
import com.flightapp.repos.FlightRepository;

@Service
public class FlightService {

	@Autowired
	FlightRepository repos;

	public List<Flight> searchFlight(SearchFlight srch) {
		return repos.findByFltDateAndFromLocAndToLoc(srch.getFltDate(), srch.getFromLoc(), srch.getToLoc());
	}

	public String registerFlight(Flight flight) {
		if (repos.save(flight) == null)
			throw new RuntimeException("Flight registration failed");
		return "Flight details added successfully";

	}
}
