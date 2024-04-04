package com.example.demo.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.jpa.entity.User;
import com.example.demo.jpa.repository.Userrepository;
import jakarta.transaction.Transactional;

@Service
public class Userservice {
	@Autowired
	Userrepository userrepository;
	
	//Functions
		// Create
	@Transactional
	public User createUser(User user) {
		User createdUser =  null;
		createdUser = userrepository.save(user);
		return createdUser;
	}
	
		// Read
	public List<User> getAllUser(){
		List<User> users = null;
		users = userrepository.findAll();
		return users;
	}
	
		// Update
	@Transactional
	public User UpdatedUser(String email, String username, String password, int age) {
		
		User user = userrepository.findByEmail(email);
		
		 if (username != null) {
			 user.setUsername(username);
	        }
		 if (password != null) {
			 user.setPassword(password);
		 }
		 if (age > 0) {
			 user.setAge(age);;
		 }
		 User updateUser = userrepository.save(user);
		 return updateUser;
	}
	
		// Delete by name
	@Transactional
	public void deleteUser(String username) {
		User user = userrepository.findByUsername(username);
		userrepository.delete(user);
	}
	
		// Search by name
	public List<User> findByUsernameContainingIgnoreCase(String username) {
		List<User> users = userrepository.findByUsernameContainingIgnoreCase(username);
		return users;
	}
	
		// Search by email
	public User findByEmail(String email) {
		return userrepository.findByEmail(email);
	}
	
		// Count
	@Transactional
	public long totalUser() {
		return userrepository.count();
	}
}
