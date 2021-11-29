package com.sunbeam.daos;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sunbeam.pojos.User;

@Repository
public class UserDaoImpl {
	private JdbcTemplate jdbcTemplate;
	
	// @Autowired // implicit
	public UserDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public User findByEmail(String email) {
		String sql = "SELECT id, name, email, password, reg_amt, reg_date, role FROM users WHERE email = ?";
		UserRowMapperImpl userRowMapper = new UserRowMapperImpl();
		List<User> list = jdbcTemplate.query(sql, userRowMapper, email);
			// arg1: sql query to execute -- SELECT
			// arg2: rowMapper --> to convert resultSet into User pojo
			// arg3: query params in case of parameterized query (?)
		
			// query() method -- "Internals"
				// 1. get the connection from DataSource
				// 2. create the PreparedStatement (using sql in arg1)
				// 3. set stmt param (stmt.setString(email <-- arg3))
				// 4. ResultSet rs = stmt.executeQuery();
				// 5. int rowNum = 1;
				// 6. List<> list = new ArrayList<>();
				// 7. while(rs.next()) { 
				//		pojo = rowMapper.mapRow(rs, rowNum++); // rowMapper <-- arg2
				//		list.add(pojo)
				//	  }
				// 8. Close rs, stmt, and return con to pool (datasource)
				// 9. return list;
		if(list.isEmpty())
			return null;
		return list.get(0);
	}
}



