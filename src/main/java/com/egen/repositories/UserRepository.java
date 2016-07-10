package com.egen.repositories;

import org.springframework.stereotype.Repository;

import com.egen.beans.User;

@Repository
public interface UserRepository {
public User getUser(String username);
public User createUser(User user);
}
