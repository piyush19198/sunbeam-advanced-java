package com.sunbeam.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sunbeam.pojos.Tutorial;

@Repository
public class TutorialDaoImpl {
	private JdbcTemplate jdbcTemplate;
	private TutorialRowMapperImpl tutorialRowMapper;
	
	@Autowired
	public TutorialDaoImpl(JdbcTemplate jdbcTemplate, TutorialRowMapperImpl tutorialRowMapper) {
		this.jdbcTemplate = jdbcTemplate;
		this.tutorialRowMapper = tutorialRowMapper;
	}

	public List<Tutorial> findAll() {
		String sql = "SELECT tut.id, tut.name, tut.author, tut.publish_date, tut.visits, tut.contents, tut.topic_id, top.name AS topic_name FROM tutorials tut LEFT JOIN topics top ON tut.topic_id = top.id";
		List<Tutorial> list = jdbcTemplate.query(sql, tutorialRowMapper);
		return list;
	}
	
	public List<Tutorial> findByTopicId(int topicId) {
		String sql = "SELECT tut.id, tut.name, tut.author, tut.publish_date, tut.visits, tut.contents, tut.topic_id, top.name AS topic_name FROM tutorials tut LEFT JOIN topics top ON tut.topic_id = top.id WHERE tut.topic_id = ? ORDER BY tut.visits DESC";
		List<Tutorial> list = jdbcTemplate.query(sql, tutorialRowMapper, topicId);
		return list;		
	}
	
	public Tutorial findById(int tutorialId) {
		String sql = "SELECT tut.id, tut.name, tut.author, tut.publish_date, tut.visits, tut.contents, tut.topic_id, top.name AS topic_name FROM tutorials tut LEFT JOIN topics top ON tut.topic_id = top.id WHERE tut.id = ?";		
		List<Tutorial> list = jdbcTemplate.query(sql, tutorialRowMapper, tutorialId);
		if(list.isEmpty())
			return null;
		return list.get(0);		
	}
	
	public int incrementTutorialVisitCount(int tutorialId) {
		String sql = "UPDATE tutorials SET visits = visits + 1 WHERE id = ?";
		int rowsAffected = jdbcTemplate.update(sql, tutorialId);
		return rowsAffected;
	}

	public int save(Tutorial tutorial) {
		String sql = "UPDATE tutorials SET name=?, author=?, publish_date=?, contents=?, visits=? WHERE id=?";
		int count = jdbcTemplate.update(sql, tutorial.getName(), tutorial.getAuthor(), tutorial.getPublishDate(), tutorial.getContents(), tutorial.getVisits(), tutorial.getId());
		return count;
	}
}

