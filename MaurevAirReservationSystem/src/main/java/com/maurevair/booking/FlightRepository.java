package com.maurevair.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FlightRepository extends JpaRepository<Flight, Long> {
	@Query("SELECT f FROM Flight f WHERE f.country = ?1")
	public Flight findByCountry(String country);
	
}

