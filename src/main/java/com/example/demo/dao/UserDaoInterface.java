package com.example.demo.dao;

import com.example.demo.bean.UserBean;
import com.example.demo.entities.ParkingSpotsEntity;
import com.example.demo.entities.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserDaoInterface {


    String registerUser(UserEntity userReg);



    UserBean loginUser(UserEntity userDetails);
    public List<UserEntity> getUserEmails();

    public UserBean insertCoordinates(ParkingSpotsEntity parkingDetails);
    public UserEntity getApprovedAdmin(ParkingSpotsEntity parkingSpotsEntity);



}
