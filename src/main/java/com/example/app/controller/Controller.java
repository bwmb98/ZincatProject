package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.model.User;
import com.example.app.response.ResponseEP;
import com.example.app.service.RegServices;


@RestController
@CrossOrigin

public class Controller {
  
	@Autowired
	private RegServices service;
	
	@PostMapping("/userRegister")

	public ResponseEP registerUser(@RequestBody User user){
		
		return service.saveUser(user);
	}
	
	@PostMapping("/userLogin")

	public ResponseEP loginUser(@RequestBody User user) throws Exception {
		
		return service.loginUser(user);
		}
	}
