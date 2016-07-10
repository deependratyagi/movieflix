package com.egen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.egen.beans.User;
import com.egen.service.UserService;

@RestController
public class RestMovieFlix {

	@Autowired
	private UserService us;
	
	@RequestMapping(value="/createUser",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public User createUser(@RequestBody User user)
	{
	  User u = us.createUser(user); 
	  return user;
	}
	
}
