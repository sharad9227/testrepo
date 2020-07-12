package com.example.demo.service;

import com.example.demo.bean.ParkingSpotsBean;
import com.example.demo.bean.UserBean;
import com.example.demo.dao.UserDao;
import com.example.demo.dao.UserDaoInterface;
import com.example.demo.entities.ParkingSpotsEntity;
import com.example.demo.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class UserServiceImpl implements UserServiceInterface{
    @Autowired
    private UserDaoInterface userDaoInterface;


    @Override
    public String registerUser(UserBean userDetails) {

        UserEntity user =new UserEntity();
        user.setUserFirstName(userDetails.getUserFirstName());
        user.setUserLastName(userDetails.getUserLastName());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        user.setPlateNumber(userDetails.getPlateNumber());
        user.setUserType(userDetails.getUserType());
        user.setPlateNumber(userDetails.getPlateNumber());
        // site admin to check later on
        if(userDetails.getUserType().equals("Parking Owner")) {
            user.setApprovedStatus(false);
        }
        //user.setUpdatedTime(S);
      //  UserEntity.setFullName(userDetails.getFullName());



      return  this.userDaoInterface.registerUser(user);
    }

    @Override
    public UserBean loginUser(UserBean userDetails)
    {
        UserEntity entity=new UserEntity();
        entity.setPassword(userDetails.getPassword());
        entity.setEmail(userDetails.getEmail());
        UserDao dao= new UserDao();
        UserBean user = dao.loginUser(entity);
        return user;




    }


    @Override
    public UserBean insertCoordinates(ParkingSpotsBean parkingDetails)
    {
        ParkingSpotsEntity parkingSpotsEntity=new ParkingSpotsEntity();
        UserDao dao= new UserDao();
        UserBean bean= new UserBean();
        parkingSpotsEntity.setParking_user_id(parkingDetails.getParking_user_id());
        UserEntity user =dao.getApprovedAdmin(parkingSpotsEntity);
        try {

            if (user.isApprovedStatus() && user.getUserId() != 0) {
                parkingSpotsEntity.setId(1);
                parkingSpotsEntity.setLatitude(parkingDetails.getLatitude());
                parkingSpotsEntity.setLongitude(parkingDetails.getLongitude());
                parkingSpotsEntity.setParking_user_id(parkingDetails.getParking_user_id());
                parkingSpotsEntity.setActiveStatus(true);
                parkingSpotsEntity.setVacantSpots(parkingDetails.getVacantSpots());
                parkingSpotsEntity.setUpdatedTime(new Timestamp(System.currentTimeMillis()));
                bean=dao.insertCoordinates(parkingSpotsEntity);
            }
    }
            catch (Exception e) {
                System.out.println(e);
            }
            return bean;


        }


}

