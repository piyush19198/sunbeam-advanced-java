package com.sunbeam.daos;

import com.sunbeam.pojos.Vendor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class VendorRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Vendor vendor = new Vendor();
		vendor.setId(rs.getInt(1));
		vendor.setName(rs.getString(2));
		vendor.setEmail(rs.getString(3));
		vendor.setPassword(rs.getString(4));
		vendor.setRole(rs.getString(9));
		vendor.setRegAmount(rs.getDouble(7));
		vendor.setCellNo(rs.getString(6));
		vendor.setCity(rs.getString(5));
		vendor.setDate(rs.getDate(8));
		System.out.println("RowMapperCalled" + vendor);
		return vendor;

	}

}
