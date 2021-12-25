package com.flightapp.repos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer>{

	public List<Flight> findByFltDateAndFromLocAndToLoc(Date fltDate,String fromLoc,String toLoc);
}

