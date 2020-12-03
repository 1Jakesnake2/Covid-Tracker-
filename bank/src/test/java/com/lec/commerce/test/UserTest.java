package com.lec.commerce.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.lec.commerce.domain.dUser;
import com.lec.commerce.repository.UserRepository;
import com.lec.commerce.service.UserService; 


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserTest {

	@Autowired UserService userservice;
	@Autowired UserRepository userRepository;
	
	@Test
	public void TestUserCreate() {
	  
		dUser duser = new dUser();
		duser.setPassword("abcd");
		duser.setEmail("tkang@ucmo.edu");
		String savedId = userservice.join(duser);
		
		assertEquals(duser, userRepository.findOne(savedId));
		
	}
	
}
