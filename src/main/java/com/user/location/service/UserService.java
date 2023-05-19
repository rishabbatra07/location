package com.user.location.service;

import com.user.location.controller.Controller;
import com.user.location.dao.UserRepository;
import com.user.location.entity.UserLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    static Logger logger= Logger.getLogger(String.valueOf(UserService.class));


    public List<UserLocation> getListOfUsers()
    {
        return userRepository.findAll();
    }

    public UserLocation save(UserLocation userLocation)
    {
        userRepository.save(userLocation);
        return userLocation;
    }

    public List<UserLocation> findAll()
    {
        return userRepository.findAll();

    }

    //updating a record
    public UserLocation  update(UserLocation userLocation,Long id) {
        logger.info("print logs" + id);
        Optional<UserLocation> findUserLocationId = userRepository.findById(id);
        if(findUserLocationId.isPresent()){
            findUserLocationId.get().setLocationName(userLocation.getLocationName());
            findUserLocationId.get().setLatitude(userLocation.getLatitude());
            findUserLocationId.get().setLongitude(userLocation.getLongitude());
        }
        else{
            return null;
        }

        return userRepository.save(findUserLocationId.get());

    }

}
