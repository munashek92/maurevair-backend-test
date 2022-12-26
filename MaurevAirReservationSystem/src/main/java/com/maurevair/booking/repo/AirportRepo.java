package com.maurevair.booking.repo;

import com.maurevair.booking.entity.Flights;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepo extends JpaRepository<Flights,Long> {
}
