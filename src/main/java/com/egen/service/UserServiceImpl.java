package com.egen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.egen.beans.User;
import com.egen.repositories.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository ur;
	
	public boolean checkLoginCredentials(String username,String password){
		
		User user = ur.getUser(username);
		if(user!=null && user.getPassword().equals(password))
		{
			return true;
		}
		
		return false;
	}
	
	public User createUser(User user){
		User u = ur.createUser(user);
		return u;
	}
	
}
