package com.flightapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{

}
