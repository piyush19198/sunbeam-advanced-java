package com.sunbean.services;

import com.sunbean.entities.User;

public interface UserServices {

	User authenticate(String email, String password);

	User findByEmail(String email);

}
