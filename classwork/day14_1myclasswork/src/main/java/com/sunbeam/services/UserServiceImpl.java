package com.sunbeam.services;

import org.springframework.stereotype.Service;

import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

@Service
public class UserServiceImpl {
	private UserDaoImpl userDao;

	public UserServiceImpl(UserDaoImpl userDao) {
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










