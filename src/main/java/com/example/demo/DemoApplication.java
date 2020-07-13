package com.example.demo;

import com.example.demo.dao.UserDao;
import com.example.demo.service.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
//		SpringApplication.run(UserServiceImpl.class,args);
//		SpringApplication.run(UserDao.class,args);
	}

}
