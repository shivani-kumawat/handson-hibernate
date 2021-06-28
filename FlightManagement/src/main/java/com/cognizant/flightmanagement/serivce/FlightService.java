package com.cognizant.flightmanagement.serivce;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.flightmanagement.model.Flight;
import com.cognizant.flightmanagement.model.Passenger;
import com.cognizant.flightmanagement.repository.IFlightRepository;

@Service
public class FlightService {

	private Logger logger = LoggerFactory.getLogger(FlightService.class);
	@Autowired
	private IFlightRepository flightRepository;

	public String createFlight(Flight f) {
		flightRepository.saveAndFlush(f);
		logger.info("Successfully created");
		return "Flight Successfully Created";

	}

	public List<Flight> getAllFlight() {
		return flightRepository.findAll();

	}

	public Flight getFlightById(String id) {
		Optional<Flight> result = flightRepository.findById(id);
		if (result.isPresent())
			return result.get();
		else
			logger.error("Flight not available by id");
		System.out.println("Flight not avialable by Id");
		return null;

	}

	public String removeFlight(String id) {
		Optional<Flight> op = flightRepository.findById(id);
		if (op.isPresent()) {
			flightRepository.delete(op.get());
			logger.info("Flight with id:{} deleted", id);
			return "flight deleted";
		} else {
			logger.info("Flight with id:{} not availabel", id);
			return "flight not available";
		}
	}

	public String updateFlight(Flight s) {
		Optional<Flight> op = flightRepository.findById(s.getId());
		if (op.isPresent()) {
			flightRepository.saveAndFlush(s);
			System.out.println("jy" + op.get());
			return "Flight updated";
		} else {
			return "Flight not available";
		}

	}

	public String addPassenger(Flight f, Passenger p) {

		if (f.getFlightType().equalsIgnoreCase("Economy")) {
			f.addPassenger(p);
			updateFlight(f);
			return "passenger is added successfully";

		}

		else {
			if (p.isVip()) {
				f.addPassenger(p);
				updateFlight(f);
				return "passenger added successfully";

			} else {

				return null;
			}
		}

	}

	public String removePassenger(Flight f, Passenger p) {

		if (!p.isVip()) {
			f.removePassenger(p);
			updateFlight(f);
			return "passenger is Removed Successfully";

		} else {
			return null;
		}

	}

	public List<Passenger> getAllPassenger(String id) {
		Flight f = getFlightById(id);
		return f.getPassengers();
	}

}
