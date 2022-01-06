package com.flightapp.repos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.flightapp.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

	//@Query("select u from Flight u where u.fltDate= : fltDate and u.fromLoc= :fromLoc and u.toLoc= :toLoc and u.airlineStatus= :status")
	public List<Flight> findByFltDateAndFromLocAndToLocAndAirlineStatus(Date fltDate,String fromLoc, String toLoc, String airlineStatus);

	@Modifying
	@Query("update Flight u set u.airlineStatus = :status where u.airLineName = :airLineName")
	int updateFlightStatusForName(@Param("status") String airlineStatus, @Param("airLineName") String airLineName);
}
