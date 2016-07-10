package com.egen.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.egen.beans.User;

@Repository
public class UserRepositoryImpl implements UserRepository{

	@Autowired
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public User getUser(String username) {
		TypedQuery<User> tq = (TypedQuery<User>)em.createQuery("select u from User u where u.username=:username");
		tq.setParameter("username", username);
		User user = tq.getSingleResult();
		
		return user;
	}
	
	public User createUser(User user)
	{
		em.persist(user);
		return user;
	}

}
