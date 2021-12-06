package com.sunbean.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbean.daos.UserDao;
import com.sunbean.entities.User;

@Service
@Transactional
public class UserServicesImpl implements UserServices{
	@Autowired
	private UserDao uDao;

	@Override
	public User findByEmail(String email) {
		return uDao.findByEmail(email);
	}
	
	@Override
	public User authenticate(String email, String password) {
		User user = findByEmail(email);
		if(user!=null && user.getPassword().equals(password))
			return user;
		return null;
	}
}
