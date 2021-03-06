package com.sunbean.services;

import java.util.List;

import com.sunbean.entities.Mobile;

public interface MobileServices {

	List<Mobile> findByMobileId(int id);

	Mobile findById(int id);

	boolean deleteById(int id);

	Mobile save(Mobile mobile);

}
