package com.netjstech.backend.service;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netjstech.backend.dao.ScheduleRepository;
import com.netjstech.backend.dao.ScheduledFlightRepository;
import com.netjstech.backend.exception.RecordNotFoundException;
import com.netjstech.backend.exception.ScheduledFlightNotFoundException;
import com.netjstech.backend.entities.ScheduledFlight;

@Service
public class ScheduledFlightServiceImpl implements ScheduledFlightService {
	@Autowired
	ScheduledFlightRepository repository;

	@Autowired
	ScheduleRepository scheduleRepository;

	@Autowired
	BookingService bookingService;

	
	@Override
	public ScheduledFlight addScheduledFlight(ScheduledFlight scheduledFlight) {
		return repository.save(scheduledFlight);
	}

	@Override
	public ScheduledFlight modifyScheduledFlight(ScheduledFlight scheduleFlight) {
		return repository.save(scheduleFlight);
	}

	@Override
	public String removeScheduledFlight(BigInteger flightId) throws RecordNotFoundException {
		if (flightId == null)
			throw new RecordNotFoundException("Enter flight Id");
		Optional<ScheduledFlight> scheduleFlight = repository.findById(flightId);
		if (!scheduleFlight.isPresent())
			throw new RecordNotFoundException("Enter a valid Flight Id");
		else {
			repository.deleteById(flightId);
		}
		return "Scheduled flight with ID " + flightId + " is deleted";
	}

	
	@Override
	public Iterable<ScheduledFlight> viewAllScheduledFlights() {
		return repository.findAll();
	}

	@Override
	public ScheduledFlight viewScheduledFlight(BigInteger flightId) throws ScheduledFlightNotFoundException {
		if (flightId == null)
			throw new ScheduledFlightNotFoundException("Enter flight Id");
		Optional<ScheduledFlight> scheduleFlight = repository.findById(flightId);
		if (!scheduleFlight.isPresent())
			throw new ScheduledFlightNotFoundException("Enter a valid Flight Id");
		else
			return scheduleFlight.get();
	}

}