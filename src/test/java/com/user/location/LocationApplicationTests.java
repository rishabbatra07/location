package com.user.location;

import com.user.location.dao.UserRepository;
import com.user.location.entity.UserLocation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class LocationApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void whenFindingCustomerById_thenCorrect() {
		userRepository.save(new UserLocation("user", 1, 2));
		//assertEquals(42, Integer.sum(19, 23));
	//	assertEquals(userRepository.findById(1),"true");

	}

}


