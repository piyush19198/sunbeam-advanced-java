package com.sunbean.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbean.daos.MobileDao;
import com.sunbean.entities.Mobile;

@Service
@Transactional
public class MobileServicesImpl implements MobileServices{
	
	@Autowired
	private MobileDao mDao;
	
	@Override
	public Mobile findById(int id) {
		Optional<Mobile> m = mDao.findById(id);
		return m.orElse(null);
	}

	@Override
	public List<Mobile> findByMobileId(int id) {
		List<Mobile> mlist = mDao.findByUserEmpid(id);
		return null;
	}

	@Override
	public boolean deleteById(int id) {
		if(mDao.existsById(id)) {
			mDao.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Mobile save(Mobile mobile) {
		Mobile mob = mDao.save(mobile);
		return mob;
	}
}
