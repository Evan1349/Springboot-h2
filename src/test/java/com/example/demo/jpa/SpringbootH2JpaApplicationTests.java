package com.example.demo.jpa;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import com.example.demo.jpa.entity.User;
import com.example.demo.jpa.repository.Userrepository;
import com.example.demo.jpa.service.Userservice;
import jakarta.transaction.Transactional;

@SpringBootTest
class SpringbootH2JpaApplicationTests {

	@Autowired
	Userrepository userrepository;
	
	@Autowired
	Userservice userservice;
	
	
	//create
	@Test
	@Transactional
	@Rollback(false)
	void contextLoads() {
//		User user1 = User.builder().username("Evan").password("123").email("abc@gmail.com").age(33).build();
//		User user2 = User.builder().username("John").password("Jopapa").email("papago@gmail.com").age(55).build();
//		User user3 = User.builder().username("Scott").password("scoooot").email("bigJ@gmail.com").age(39).build();
//		User user4 = User.builder().username("Franni").password("cuty").email("yoga@gmail.com").age(17).build();
//		User user5 = User.builder().username("Susie").password("Gb").email("class@gmail.com").age(22).build();
//		User user6 = User.builder().username("kevin").password("cool").email("javaclass@gmail.com").age(27).build();
//		User user7 = User.builder().username("Ry").password("en").email("sozbuddy@gmail.com").age(29).build();
//		User user8 = User.builder().username("Yutin").password("gitar").email("niceee@gmail.com").age(44).build();
//		User user9 = User.builder().username("Evan_test").password("123").email("abc@gmail.com").age(33).build();
//
//		User savedUser = userservice.createUser(user9);
//		System.out.println(savedUser);
		
	}
	
	//	 read
	@Test
	void contextLoads1() {
		
		List<User> users = userservice.getAllUser();
		System.out.println(users);
		
//		List<User> users = userservice.getAllUser();
//		users.forEach(System.out::println);
	}
	// update
	@Test
	@Transactional
	@Rollback(false)
	void contextLoads2() {
		System.out.println(userservice.UpdatedUser( "abc@gmail.com", null, null, 37));

	}
	// delete
	@Test
	@Transactional
	@Rollback(false)
	void contextLoads3() {
		userservice.deleteUser("Evan_test");
		System.out.println(userservice.getAllUser());
		System.out.println(userservice.totalUser());
	}
	// search-1 email
	@Test
	void contextLoads4() {
		System.out.println(userservice.findByEmail("abc@gmail.com"));
	}
	
	// search-2 name
	@Test
	void contextLoads4_1() {
		List<User> users = userservice.findByUsernameContainingIgnoreCase("u");
		System.out.println(users);
		System.out.println(users.size());
	}
	
	// total
	@Test
	void contextLoads5() {
		System.out.println(userservice.totalUser());
	}
}
