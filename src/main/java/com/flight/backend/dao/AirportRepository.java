package com.netjstech.backend.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.netjstech.backend.entities.Airport;

@Repository
public interface AirportRepository extends CrudRepository<Airport, String> {

}
