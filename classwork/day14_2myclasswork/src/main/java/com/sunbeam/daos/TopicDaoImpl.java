package com.sunbeam.daos;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sunbeam.pojos.Topic;

@Repository
public class TopicDaoImpl {
	private JdbcTemplate jdbcTemplate;

	public TopicDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Topic> findAll() {
		String sql = "SELECT id, name FROM topics";
		TopicRowMapperImpl topicRowMapper = new TopicRowMapperImpl();
		List<Topic> list = jdbcTemplate.query(sql, topicRowMapper);
		return list;
	}
}
