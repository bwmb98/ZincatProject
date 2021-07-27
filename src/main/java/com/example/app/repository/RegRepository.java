package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.app.model.User;

@Repository
public interface RegRepository extends JpaRepository<User, Integer> {
		 
	public User findByEmail(String email);
	
	public User findByEmailAndPassword(String email, String password);
	
	
}
