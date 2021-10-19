package com.netjstech.backend.Controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netjstech.backend.exception.RecordAlreadyPresentException;
import com.netjstech.backend.exception.RecordNotFoundException;
import com.netjstech.backend.entities.Users;
import com.netjstech.backend.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/createUser")
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public ResponseEntity<Users> addUser(@RequestBody Users newUser) {

		 return userService.createUser(newUser);
	}

	@GetMapping("/readAllUsers")
	public Iterable<Users> readAllUsers() {

		return userService.displayAllUser();
	}

	@PutMapping("/updateUser")
	@ExceptionHandler(RecordNotFoundException.class)
	public void updateUser(@RequestBody Users updateUser) {

		userService.updateUser(updateUser);
	}

	@GetMapping("/searchUser/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> searchUserByID(@PathVariable("id") BigInteger userId) {

		return userService.findUserById(userId);
	}

	@DeleteMapping("/deleteUser/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public void deleteBookingByID(@PathVariable("id") BigInteger userId) {

		userService.deleteUser(userId);
	}
}