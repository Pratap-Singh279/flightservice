package com.flightapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

}
