package com.egen.service;

import org.springframework.stereotype.Service;

import com.egen.beans.User;

@Service
public interface UserService {
public User createUser(User user);
public boolean checkLoginCredentials(String user,String password);
}
