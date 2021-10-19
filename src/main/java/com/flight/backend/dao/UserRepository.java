package com.netjstech.backend.dao;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import com.netjstech.backend.entities.Users;

public interface UserRepository extends CrudRepository<Users, BigInteger>{

}