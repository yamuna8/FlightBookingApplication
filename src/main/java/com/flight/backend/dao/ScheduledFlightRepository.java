package com.netjstech.backend.dao;
import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.netjstech.backend.entities.ScheduledFlight;

@Repository
public interface ScheduledFlightRepository extends CrudRepository<ScheduledFlight, BigInteger>{

}