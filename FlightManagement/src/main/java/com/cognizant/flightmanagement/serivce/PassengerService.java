package com.cognizant.flightmanagement.serivce;

import java.util.List;
import java.util.Optional;
import com.cognizant.flightmanagement.model.Flight;
import com.cognizant.flightmanagement.model.Passenger;
import com.cognizant.flightmanagement.repository.IPassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerService {
	private static int count = 0;

	@Autowired
	private IPassengerRepository passengerRepo;
	
	@Autowired
	private FlightService flightService;

	public String createPassenger(Passenger p) {
		passengerRepo.saveAndFlush(p);
		PassengerService.count = PassengerService.count + 1;
		return "Passenger Created";

	}

	public List<Passenger> getAllPassenger() {
		return passengerRepo.findAll();
	}

	public Passenger getPassengerById(String id) {
		Optional<Passenger> result = passengerRepo.findById(id);
		if (result.isPresent()) {
			return result.get();
		} else {
			System.out.println("Passenger not there");
			return null;
		}
	}

	public String removePassenger(String id) {

		Optional<Passenger> result = passengerRepo.findById(id);
		if (result.isPresent()) {
			List<Flight> list = flightService.getAllFlight();
			passengerRepo.delete(result.get());
			return "Deleted";
		} else {
			return ("Passenger not there");
		}

	}

}
