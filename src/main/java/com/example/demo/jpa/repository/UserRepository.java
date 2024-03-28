package com.example.demo.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.jpa.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
