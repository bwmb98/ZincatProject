package com.example.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.model.User;
import com.example.app.repository.RegRepository;

@Service
public class RegServices {
	
	@Autowired
	private RegRepository repos;
	
	public User saveUser(User user) {
		
		return repos.save(user);
	}
	
	public User checkuseremail(String email) {
		return repos.findByEmail(email);
	}
	
	public User checkuseremailnPassword(String email, String password) {
		return repos.findByEmailAndPassword(email, password);
	}
	
}
		
