package com.sunbeam.daos;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sunbeam.pojos.Vendor;

@Repository
public class VendorDaoImpl {
	private JdbcTemplate jdbcTemplate;

	private VendorRowMapper vendorMapper;

	@Autowired
	public VendorDaoImpl(JdbcTemplate jdbcTemplate, VendorRowMapper vendorMapper) {
		super();
		this.jdbcTemplate = jdbcTemplate;
		this.vendorMapper = vendorMapper;
	}

	public Vendor getVendor(String email) {
		String sql = "select * from vendors where email = ?";
		List<Vendor> vendorList = jdbcTemplate.query(sql, vendorMapper, email);
		if (vendorList.isEmpty())
			return null;
		else
			return vendorList.get(0);
	}

	public List<Vendor> getAllVendors() {
		String sql = "select * from vendors";
		List<Vendor> allVendors = jdbcTemplate.query(sql, vendorMapper);
		return allVendors;
	}

	public Vendor getAVendor(int id) {
		String sql = "select * from vendors where id = ?";
		List<Vendor> vendors = jdbcTemplate.query(sql, vendorMapper, id);
		if (vendors == null)
			return null;
		else
			return vendors.get(0);
	}

	public int updateAVendor(String city, String cellNo, int id) {
		String sql = "update vendors set city=?, cell_no=? where id=?";
		int exec = jdbcTemplate.update(sql, city, cellNo, id);
		return exec;
	}

	public int deleteAVendor(int id) {
		String sql = "delete from vendors where id = ?";
		int exec = jdbcTemplate.update(sql, id);
		return exec;
	}

	public int addAVendor(String name, String email, String password, String city, String cellNo, double regAmount,
			Date date, String role) {
		String sql = "insert into vendors values (default,?,?,?,?,?,?,?,?)";
		int exec = jdbcTemplate.update(sql, name, email, password, city, cellNo, regAmount, date, role);
		return exec;
	}
}
