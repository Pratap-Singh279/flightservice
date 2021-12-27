package com.flightapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.entities.Reservation;
import java.lang.String;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{
    Reservation findByPnr(Integer pnr);
    List<Reservation> findByEmail(String email);
}
