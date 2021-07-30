package com.example.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.model.User;
import com.example.app.repository.RegRepository;
import com.example.app.response.ResponseEP;

@Service
public class RegServices {

	@Autowired
	private RegRepository repos;

	public ResponseEP saveUser(User user) {
		ResponseEP rep = null;
		try {
			// service + business logic
			String checkEmail = user.getEmail();
			if (checkEmail != null && !"".equals(checkEmail)) {
				User userobj = checkuseremail(checkEmail);
				if (userobj != null) {
					rep = new ResponseEP();
					rep.setMessageString("User already exist");
					rep.setStatusCode(500);
					rep.setUserid(userobj.getUserid());
				} 
				else {
					repos.save(user);
					rep = new ResponseEP();
					rep.setMessageString("User saved successfully");
					rep.setStatusCode(200);
					rep.setUserid(1);
				}
			}
		} catch (Exception ex) {
			// what is your error response
			rep = new ResponseEP();
			rep.setMessageString("Error in user saving");
			rep.setStatusCode(405);
			rep.setUserid(0);

		}
		return rep;
	}

	public User checkuseremail(String email) {
		return repos.findByEmail(email);
	}

	public ResponseEP loginUser(User user) {
		ResponseEP rep = null;
		try {
			// service + business logic
			String tempEmail = user.getEmail();
			String tempPassword = user.getPassword();
			User userobj = null;
			if (tempEmail != null && tempPassword != null) {
				userobj= checkuseremailnPassword(tempEmail,tempPassword);
			}
				if (userobj == null) {
					rep = new ResponseEP();
					rep.setMessageString("Invalid user");
					rep.setStatusCode(401);
					}
				else {
					rep = new ResponseEP();
					rep.setMessageString("User logged-in successfully");
					rep.setStatusCode(200);
					rep.setUserid(1);
				}
		} catch (Exception ex) {
			// what is your error response
			rep = new ResponseEP();
			rep.setMessageString("Error in login");
			rep.setStatusCode(299);
			rep.setUserid(0);

		}
		return rep;
	}
	
	public User checkuseremailnPassword(String email, String password) {
		return repos.findByEmailAndPassword(email, password);
	}

}
