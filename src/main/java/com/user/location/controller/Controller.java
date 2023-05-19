package com.user.location.controller;


import com.user.location.dao.UserRepository;
import com.user.location.entity.UserLocation;
import com.user.location.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;


@RestController
@RequestMapping("/api/users")
@Slf4j
public class Controller {
	@Autowired
	UserService userService;

	static Logger logger = Logger.getLogger(String.valueOf(Controller.class));

	@Autowired
	UserRepository userRepository;

	@PostMapping("/location")
	public UserLocation createUserLocation(@RequestBody UserLocation userLocation) {
		return userService.save(userLocation);
	}

	@GetMapping("/location")
	public ResponseEntity<List<UserLocation>>  findAll()
	{
		List<UserLocation> userLocation = userService.findAll();
		// Return response entity
		if (userLocation != null && !userLocation.isEmpty()) {
			logger.info("print logs" +userLocation);
			return ResponseEntity.ok(userLocation);
		} else {
			logger.info("not print logs");
			return ResponseEntity.notFound().build();
		}
	}


	/*
	@GetMapping("/location/{nUsers}")
	public String getUsers(@PathVariable("nUsers")int nUsers) {
		//List<UserLocation> userLocation= userService.;

		int countUsers=0;
		List<UserLocation> userLocationList= userService.getListOfUsers();
		for(UserLocation u1 : userLocationList){
			if(countUsers==nUsers) break;

			else{

				countUsers++;
			}

		}

		return "somthing";

	}
	*/


	@PatchMapping("/location/{id}")
	public UserLocation updateUserLocation(@RequestBody UserLocation userLocation,@PathVariable(value = "id") Long id) {
		logger.info(id.toString());
		return userService.update(userLocation,id);

	}

}
