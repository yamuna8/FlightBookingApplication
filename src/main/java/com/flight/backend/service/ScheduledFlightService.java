package com.netjstech.backend.service;

import java.math.BigInteger;
import com.netjstech.backend.exception.RecordNotFoundException;
import com.netjstech.backend.exception.ScheduledFlightNotFoundException;
import com.netjstech.backend.entities.ScheduledFlight;

public interface ScheduledFlightService {
	public ScheduledFlight addScheduledFlight(ScheduledFlight scheduledFlight);
	public ScheduledFlight modifyScheduledFlight(ScheduledFlight scheduledFlight);
	public String removeScheduledFlight(BigInteger id) throws RecordNotFoundException;
	public Iterable<ScheduledFlight> viewAllScheduledFlights();
	public ScheduledFlight viewScheduledFlight(BigInteger id) throws ScheduledFlightNotFoundException;
	

}