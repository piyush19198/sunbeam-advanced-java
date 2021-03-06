package com.sunbeam.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.VendorDaoImpl;
import com.sunbeam.pojos.Vendor;

@Service
public class VendorServiceImpl {
	@Autowired
	VendorDaoImpl vendorDao;

	public VendorServiceImpl() {
	}

	@Autowired
	public VendorServiceImpl(VendorDaoImpl vendorDao) {
		super();
		this.vendorDao = vendorDao;
	}

	public Vendor getVendorByEmail(String email) {
		return vendorDao.getVendor(email);
	}

	public Vendor authenticateVendor(String email, String password) {
		Vendor v = vendorDao.getVendor(email);
		if (v != null && v.getPassword().equals(password))
			return v;
		else
			return null;
	}

	public List<Vendor> getAdminContents() {
		return vendorDao.getAllVendors();
	}

	public Vendor getVendorDetails(int id) {
		return vendorDao.getAVendor(id);
	}

	public int updateVendor(String city, String cellNo, int id) {
		return vendorDao.updateAVendor(city, cellNo, id);
	}

	public int deleteVendor(int id) {
		return vendorDao.deleteAVendor(id);
	}

	public int addVendor(String name, String email, String password, String city, String cellNo, double regAmount,
			Date date, String role) {
		return vendorDao.addAVendor(name, email, password, city, cellNo, regAmount, date, role);

	}
}
