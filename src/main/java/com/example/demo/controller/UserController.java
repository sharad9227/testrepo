package com.example.demo.controller;

import com.example.demo.bean.ParkingSpotsBean;
import com.example.demo.bean.UserBean;
import com.example.demo.service.ExceptionClass;
import com.example.demo.service.ResponseClass;
import com.example.demo.service.UserServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api")
public class UserController {

    public static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserServiceInterface userServiceInterface;

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

    public Object registerUser(@RequestBody UserBean userDetails) {

        String responseType = userServiceInterface.registerUser(userDetails);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", ServletUriComponentsBuilder.fromCurrentRequest().path("/{userName}").buildAndExpand(userDetails.getUserFirstName()).toUri().toString());
        if (responseType.equals("true"))
          return new ResponseEntity<Boolean>(true, httpHeaders, HttpStatus.CREATED);

        else {
            //return new ResponseEntity<Boolean>(false,httpHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
            ResponseClass customObj = new ResponseClass();
            return customObj.toResponse(new ExceptionClass(responseType));

        }

    }

    //login to application
    @RequestMapping(value = "/loginUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object loginUser(@RequestBody UserBean userDetails) {

        UserBean user=new UserBean();
        user=userServiceInterface.loginUser(userDetails);
        if (user.isLoginValid())

            return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);

        else {
            //return new ResponseEntity<Boolean>(false,httpHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
            ResponseClass customObj = new ResponseClass();
            return customObj.toResponseNotAcceptable(new ExceptionClass(user.getException().getMessage()));

        }

    }
    //insert coordinates @parkingspots by parking owner
    @RequestMapping(value = "/insertCoordinates", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object insertCoordinates(@RequestBody ParkingSpotsBean parkingSpotsBean) {

        UserBean userBean=new UserBean();
        userBean= userServiceInterface.insertCoordinates(parkingSpotsBean);
        if (userBean.getException()!=null)

            return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);

        else {
            //return new ResponseEntity<Boolean>(false,httpHeaders,HttpStatus.INTERNAL_SERVER_ERROR);
            ResponseClass customObj = new ResponseClass();
            return customObj.toResponseNotAcceptable(new ExceptionClass(userBean.getException().getMessage()));

        }

    }

//getUser

//    @RequestMapping(value = "/Users/{id}",method = RequestMethod.GET)
//    public UserBean getUserDetails(@PathVariable("id") String )








}




