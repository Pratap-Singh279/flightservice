package com.flightapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flightapp.entities.Flight;
import com.flightapp.entities.Passenger;
import com.flightapp.entities.Reservation;
import com.flightapp.models.PassengerDetails;
import com.flightapp.models.ReservationDetails;
import com.flightapp.models.SearchFlight;
import com.flightapp.models.TicketDetails;
import com.flightapp.repos.FlightRepository;
import com.flightapp.repos.PassengerRepository;
import com.flightapp.repos.ReservationRepository;

@Service
@Transactional
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
		Flight flt = findById.get();
		if (flt != null) {
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
		if (save != null)
			return "Updated successfully";
		else
			return "Update failed!!!";

	}

	public String bookingTicket(Integer flightId, ReservationDetails rsvDt) {

		Reservation rsv = new Reservation();
		rsv.setEmail(rsvDt.getEmail());
		rsv.setFlightId(flightId);
		rsv.setNumberOfSeats(rsvDt.getNumberOfSeats());
		rsv.setResrvDate(rsvDt.getResrvDate());
		Reservation save = reservRepos.save(rsv);
		for (PassengerDetails pdtl : rsvDt.getPassengersDetails()) {
			Passenger ps = new Passenger();
			ps.setFirstName(pdtl.getFirstName());
			ps.setLastName(pdtl.getLastName());
			ps.setAge(pdtl.getAge());
			ps.setPnr(save.getPnr());
			ps.setGender(pdtl.getGender());
			passengerRepos.save(ps);
		}
		return "Reservation successful!!! PNR : " + save.getPnr();
	}

	public TicketDetails getTicketDetails(int pnr) {
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$####################################");
		Reservation findByPnr = reservRepos.findByPnr(pnr);
		TicketDetails tkDtls = new TicketDetails();
		if (findByPnr == null)
			throw new RuntimeException("No ticket found with the provided PNR number : " + pnr);
		else {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>####################################");
			tkDtls.setEmail(findByPnr.getEmail());
			tkDtls.setFlightId(findByPnr.getFlightId());
			tkDtls.setPnr(findByPnr.getPnr());
			tkDtls.setNumberOfSeats(findByPnr.getNumberOfSeats());
			tkDtls.setResrvDate(findByPnr.getResrvDate());
			List<Passenger> findByReserv = passengerRepos.findByPnr(pnr);
			PassengerDetails[] psDt = new PassengerDetails[findByReserv.size()];
			int i = 0;
			for (Passenger ps : findByReserv) {
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + ps.getFirstName() + " " + ps.getAge() + " "
						+ psDt[i]);
				psDt[i] = new PassengerDetails();
				psDt[i].setAge(ps.getAge());
				psDt[i].setFirstName(ps.getFirstName());
				psDt[i].setLastName(ps.getLastName());
				psDt[i].setGender(ps.getGender());
				i++;
			}
			tkDtls.setPassengers(psDt);
			return tkDtls;
		}
	}

	public List<TicketDetails> getTicketsHistoryByEmail(String emailId) {
		List<Reservation> findByEmail = reservRepos.findByEmail(emailId);
		if (findByEmail == null)
			throw new RuntimeException("No ticket found with the provided PNR number : " + emailId);
		else {
			List<TicketDetails> tktHistList = new ArrayList<>();
			for (Reservation rs : findByEmail) {
				TicketDetails tkDtls = new TicketDetails();
				tkDtls.setEmail(rs.getEmail());
				tkDtls.setFlightId(rs.getFlightId());
				tkDtls.setPnr(rs.getPnr());
				tkDtls.setNumberOfSeats(rs.getNumberOfSeats());
				tkDtls.setResrvDate(rs.getResrvDate());
				List<Passenger> findByReserv = passengerRepos.findByPnr(rs.getPnr());
				PassengerDetails[] psDt = new PassengerDetails[findByReserv.size()];
				int i = 0;
				for (Passenger ps : findByReserv) {
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + ps.getFirstName() + " " + ps.getAge()
							+ " " + psDt[i]);
					psDt[i] = new PassengerDetails();
					psDt[i].setAge(ps.getAge());
					psDt[i].setFirstName(ps.getFirstName());
					psDt[i].setLastName(ps.getLastName());
					psDt[i].setGender(ps.getGender());
					i++;
				}
				tkDtls.setPassengers(psDt);
				tktHistList.add(tkDtls);
			}
			return tktHistList;
		}
	}
}
