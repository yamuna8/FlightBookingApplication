package com.netjstech.backend.service;

import com.netjstech.backend.exception.*;
import java.math.BigInteger;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.netjstech.backend.exception.RecordAlreadyPresentException;
import com.netjstech.backend.dao.FlightRepository;
import com.netjstech.backend.entities.Flight;

@Service
public class FlightServiceImpl implements FlightService {
	@Autowired
	FlightRepository flightRepository;
	
	@Override
	public ResponseEntity<Flight> addFlight(Flight flight) {
		Optional<Flight> findById = flightRepository.findById(flight.getFlightNo());
		try {
		if (!findById.isPresent()) {
			flightRepository.save(flight);
			return new ResponseEntity<Flight>(flight,HttpStatus.OK);
		} else
			throw new RecordAlreadyPresentException("Flight with number: " + flight.getFlightNo() + " already present");
	}
		catch(RecordAlreadyPresentException e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@Override
	public Iterable<Flight> viewAllFlight() {
		return flightRepository.findAll();
	}

	@Override
	public Flight viewFlight(BigInteger flightNumber) {
		Optional<Flight> findById = flightRepository.findById(flightNumber);
		if (findById.isPresent()) {
			return findById.get();
		}
		else
			throw new RecordNotFoundException("Flight with number: " + flightNumber + " not exists");
	    }
		
	@Override
	public Flight modifyFlight(Flight flight) {
		Optional<Flight> findById = flightRepository.findById(flight.getFlightNo());
		if (findById.isPresent()) {
			flightRepository.save(flight);
		} else
			throw new RecordNotFoundException("Flight with number: " + flight.getFlightNo() + " not exists");
		return flight;
	}

	public String removeFlight(BigInteger flightNumber) {
		Optional<Flight> findById = flightRepository.findById(flightNumber);
		if (findById.isPresent()) {
			flightRepository.deleteById(flightNumber);
			return "Flight removed!!";
		} else
			throw new RecordNotFoundException("Flight with number: " + flightNumber + " not exists");

	}
}