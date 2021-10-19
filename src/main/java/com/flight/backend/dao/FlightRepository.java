package com.netjstech.backend.dao;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.netjstech.backend.entities.Flight;
@Repository
public interface FlightRepository extends CrudRepository<Flight,BigInteger>{

}
