package com.maurevair.booking;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class FlightRepositoryTests {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private FlightRepository repo;
	
	@Test
	public void testCreateFlight() {
		Flight flight = new Flight();
		flight.setCountry("Syria");
		flight.setRegion("Middle East");
		flight.setCity("Damascus");
		flight.setAirportCode("Da");
		
		Flight savedFlight = repo.save(flight);
		
		Flight existFlight = entityManager.find(Flight.class, savedFlight.getId());
		
		assertThat(flight.getCountry()).isEqualTo(existFlight.getCountry());
		
	}
	
	@Test
	public void testFindByCountry() {
		String country = "Israel";
		Flight flight = repo.findByCountry(country);
		
		assertThat(flight.getCountry()).isEqualTo(country);
	}
}

