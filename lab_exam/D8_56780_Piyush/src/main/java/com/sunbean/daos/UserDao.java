package com.sunbean.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbean.entities.User;

public interface UserDao extends JpaRepository<User, Integer>{

	User findByEmail(String email);

}
