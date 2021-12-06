package com.sunbean.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbean.entities.Mobile;

public interface MobileDao extends JpaRepository<Mobile, Integer>{

	List<Mobile> findByUserEmpid(int id);

}
