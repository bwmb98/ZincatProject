package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.model.User;
import com.example.app.service.RegServices;


@RestController
@CrossOrigin

public class Controller {
  
	@Autowired
	private RegServices service;
	
	@PostMapping("/userRegister")
//	@CrossOrigin(origins = "http://localhost:4200")

	public User registerUser(@RequestBody User user) throws Exception{

		String checkEmail = user.getEmail();
			if (checkEmail != null && !"".equals(checkEmail)) {
				User userobj= service.checkuseremail(checkEmail);
					if (userobj != null) {
						throw new Exception ("User is already exist");
					}
			}
		

		User userObj=null;
		userObj=service.saveUser(user);
		
		return userObj;
	}
	
	
//	@PostMapping("/userReg")
//	public ResponseEP newUser(@RequestBody User user) {
//		ResponseEP res = null;
//		try {
//			// service + business logic
//			String checkEmail = user.getEmail();
//			if (checkEmail != null && !"".equals(checkEmail)) {
//				User userobj= service.checkuseremail(checkEmail);
//					if (userobj != null) {
//						res = new ResponseEP();
//						res.setMessageString("User already exist");
//						res.setStatusCode(500);
//						//res.setUserid(userobj.getUserid());
//					}else {
//						service.saveUser(user);
//						res = new ResponseEP();
//						res.setMessageString("User saved successfully");
//						res.setStatusCode(200);
//						//res.setUserid(1);
//					}
//			}
//		}catch(Exception ex) {
//			// what is your error response
//			res = new ResponseEP();
//			res.setMessageString("Error in user saving");
//			res.setStatusCode(405);
//			//res.setUserid(0);
//			
//		}
//		return res;
//	}
	
	
	@PostMapping("/userLogin")
//	@CrossOrigin(origins = "http://localhost:4200")

	
	public User loginUser(@RequestBody User user) throws Exception {
		
		String tempEmail = user.getEmail();
		String tempPassword = user.getPassword();
			User userobj = null;
				if (tempEmail != null && tempPassword != null) {
					userobj = service.checkuseremailnPassword(tempEmail, tempPassword);
				}
						if (userobj == null) {
							throw new Exception ("Invalid User");
						}
						
			return userobj;
		}
	}
