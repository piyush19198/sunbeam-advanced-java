package com.sunbeam.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.pojos.User;

public interface UserDao extends JpaRepository<User, Integer> {
	User findByEmail(String email);
}


