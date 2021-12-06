package com.sunbeam.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.daos.UserDao;
import com.sunbeam.pojos.User;

@Transactional
@Service
public class UserServiceImpl {
	
	private UserDao userDao;
	// constructor based auto-wiring
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	public User authenticateUser(String email, String password) {
		User user = userDao.findByEmail(email);
		if(user != null && user.getPassword().equals(password))
			return user;
		return null;
	}
}