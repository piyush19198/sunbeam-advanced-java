package com.sunbeam.daos;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.sunbeam.pojos.Tutorial;

@Component
public class TutorialRowMapperImpl implements RowMapper<Tutorial> {
	public Tutorial mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
		Tutorial tutorial = new Tutorial();
		tutorial.setId(rs.getInt("id"));
		tutorial.setName(rs.getString("name"));
		tutorial.setAuthor(rs.getString("author"));
		tutorial.setPublishDate(rs.getDate("publish_date"));
		tutorial.setVisits(rs.getInt("visits"));
		tutorial.setContents(rs.getString("contents"));
		tutorial.setTopicId(rs.getInt("topic_id"));
		tutorial.setTopic(rs.getString("topic_name"));
		return tutorial;
	}
}
