package com.example.demo.jpa.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.jpa.entity.User;

public interface Userrepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
	User findByUsername(String username);
	List<User> findByUsernameContaining(String username);
	
}
