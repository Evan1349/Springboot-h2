package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;


public class Userservice {
	@Autowired
	UserRepository userRepository;
	
	// Functions
		//   Create
			public User createUser(User user) {
				User createdUser = null;
				createdUser = userRepository.save(user);
				return createdUser;
			}
		//   Read
			public List<User> getAllUser() {
				List<User> users = null;
				users = userRepository.findAll();			
				return (users.size()==0)?null:users;
			}
		// 	 Update
			public User UpdatedUser(Long id, String username, String password, String email, int age) {
				
				User user = userRepository.getReferenceById(id);
				
				 if (username != null) {
					 user.setUsername(username);
			        }
				 if (password != null) {
					 user.setPassword(password);
				 }
				 if (email != null) {
					 user.setEmail(email);
				 }
				 if (age > 0) {
					 user.setAge(age);
				 }
				User updateUser = userRepository.save(user);
				
				return updateUser;
			}
		//   Delete
			public void deleteUser(User user) {
				userRepository.delete(user);
			}
		//   Search
			public User searchUser(Long id) {
				User result = userRepository.getReferenceById(id);
				return result;
			}
		//   Count
			public Long totalUser() {
				return userRepository.count();
			}
}
