package com.example.demo.service;

import com.example.demo.bean.ParkingSpotsBean;
import com.example.demo.bean.UserBean;
import org.springframework.stereotype.Service;


public interface UserServiceInterface {

    String registerUser(UserBean bean);
    UserBean loginUser(UserBean userDetails);
    UserBean insertCoordinates(ParkingSpotsBean parkingDetails);

}
