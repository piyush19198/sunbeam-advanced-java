package com.sunbeam.daos;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sunbeam.pojos.Topic;

public class TopicRowMapperImpl implements RowMapper<Topic> {
	@Override
	public Topic mapRow(ResultSet rs, int rowNum) throws SQLException {
		Topic topic = new Topic();
		topic.setId(rs.getInt("id"));
		topic.setName(rs.getString("name"));
		return topic;
	}
}

