package com.flightapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.entities.Flight;
import com.flightapp.entities.Passenger;
import com.flightapp.entities.Reservation;
import com.flightapp.models.PassengerDetails;
import com.flightapp.models.ReservationDetails;
import com.flightapp.models.SearchFlight;
import com.flightapp.repos.FlightRepository;
import com.flightapp.repos.PassengerRepository;
import com.flightapp.repos.ReservationRepository;

@Service
public class FlightService {

	@Autowired
	FlightRepository repos;
	
	@Autowired
	ReservationRepository reservRepos;
	
	@Autowired
	PassengerRepository passengerRepos;

	public List<Flight> searchFlight(SearchFlight srch) {
		return repos.findByFltDateAndFromLocAndToLoc(srch.getFltDate(), srch.getFromLoc(), srch.getToLoc());
	}

	public String registerFlight(Flight flight) {
		if (repos.save(flight) == null)
			throw new RuntimeException("Flight registration failed");
		return "Flight details added successfully";

	}

	public String updateFlight(Flight flight) {
		Optional<Flight> findById = repos.findById(flight.getFlightId());
		Flight flt=findById.get();
		if(flt!=null) {
			flt.setAirLineName(flight.getAirLineName());
			flt.setAirlineStatus(flight.getAirlineStatus());
			flt.setArrTime(flight.getArrTime());
			flt.setDepTime(flight.getDepTime());
			flt.setFltDate(flight.getFltDate());
			flt.setFromLoc(flight.getFromLoc());
			flt.setToLoc(flight.getToLoc());
			flt.setInstrumentUsed(flight.getInstrumentUsed());
			flt.setMeal(flight.getMeal());
			flt.setNumberOfRows(flight.getNumberOfRows());
			flt.setTotalAvlBusClSeats(flight.getTotalAvlBusClSeats());
			flt.setTotalAvlNonBusClSeats(flight.getTotalAvlNonBusClSeats());
		}
		Flight save = repos.save(flt);
		if(save!=null)
			return "Updated successfully";
		else 
			return "Update failed!!!";
			
	}

	public String bookingTicket(Integer flightId,ReservationDetails rsvDt) {
		/*
		 Customer customer = new Customer();
		customer.setName("Chadd");
		PhoneNumber phoneNumber1 = new PhoneNumber();
		phoneNumber1.setNumber("4654659060");
		phoneNumber1.setType("Home");

		PhoneNumber phoneNumber2 = new PhoneNumber();
		phoneNumber2.setNumber("6576579868");
		phoneNumber2.setType("Cell");

		customer.addPhoneNumber(phoneNumber1);
		customer.addPhoneNumber(phoneNumber2);
		repository.save(customer); */
		Reservation rsv = new Reservation();
		rsv.setEmail(rsvDt.getEmail());
		rsv.setFlightId(flightId);
		rsv.setNumberOfSeats(rsvDt.getNumberOfSeats());
		rsv.setResrvDate(rsvDt.getResrvDate());
		for(PassengerDetails pdtl : rsvDt.getPassengersDetails()) {
			rsv.addPassanger(new Passenger(pdtl.getFirstName(),pdtl.getLastName(),pdtl.getGender(),pdtl.getAge()));
		}		
		
		Reservation save = reservRepos.save(rsv);
		return "Reservation successful!!! PNR : "+save.getPnr();
	}

	public Reservation getTicketDetails(int pnr) {
		Optional<Reservation> findById = reservRepos.findById(pnr);
		if(!findById.isPresent()) 
			throw new RuntimeException("No ticket found with the provided PNR number : "+pnr );
		System.out.println("#################>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("#################>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("#################>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("#################>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("#################>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("#################>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("#################>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("#################>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println(findById.get());
		return findById.get();
	}
}
