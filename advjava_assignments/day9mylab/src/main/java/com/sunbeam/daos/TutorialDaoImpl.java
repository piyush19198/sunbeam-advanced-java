package com.sunbeam.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sunbeam.pojos.Topic;
import com.sunbeam.pojos.Tutorial;
import com.sunbeam.utils.DbUtil;

public class TutorialDaoImpl implements AutoCloseable {
	private Connection con;

	public TutorialDaoImpl() throws Exception {
		con = DbUtil.getConnection();
	}
	public void close() {
		try {
			if (con != null)
				con.close();
		} catch (Exception e) {
		}
	}

	public List<Topic> getTopics() throws Exception {
		List<Topic> list = new ArrayList<>();
		String sql = "SELECT id, name FROM topics";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			try(ResultSet rs = stmt.executeQuery()) {
				while(rs.next()) {
					Topic topic = new Topic();
					topic.setId(rs.getInt("id"));
					topic.setName(rs.getString("name"));
					list.add(topic);
				}
			}
		}
		return list;
	}

	public List<Tutorial> getTutorials(int topicId) throws Exception {
		List<Tutorial> list = new ArrayList<>();
		String sql = "SELECT tut.id, tut.name, tut.author, tut.publish_date, tut.visits, tut.contents, tut.topic_id, top.name AS topic_name FROM tutorials tut LEFT JOIN topics top ON tut.topic_id = top.id WHERE tut.topic_id = ? ORDER BY tut.visits DESC";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, topicId);
			try(ResultSet rs = stmt.executeQuery()) {
				while(rs.next()) {
					Tutorial tutorial = new Tutorial();
					tutorial.setId(rs.getInt("id"));
					tutorial.setName(rs.getString("name"));
					tutorial.setAuthor(rs.getString("author"));
					tutorial.setPublishDate(rs.getDate("publish_date"));
					tutorial.setVisits(rs.getInt("visits"));
					tutorial.setContents(rs.getString("contents"));
					tutorial.setTopicId(rs.getInt("topic_id"));
					tutorial.setTopic(rs.getString("topic_name"));
					list.add(tutorial);
				}
			}
		}
		return list;
	}

	public Tutorial getTutorial(int tutorialId) throws Exception {
		String sql = "SELECT tut.id, tut.name, tut.author, tut.publish_date, tut.visits, tut.contents, tut.topic_id, top.name AS topic_name FROM tutorials tut LEFT JOIN topics top ON tut.topic_id = top.id WHERE tut.id = ?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, tutorialId);
			try(ResultSet rs = stmt.executeQuery()) {
				if(rs.next()) {
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
		}
		return null;
	}
	
	public List<Tutorial> getTutorials() throws Exception {
		List<Tutorial> list = new ArrayList<>();
		String sql = "SELECT tut.id, tut.name, tut.author, tut.publish_date, tut.visits, tut.contents, tut.topic_id, top.name AS topic_name FROM tutorials tut LEFT JOIN topics top ON tut.topic_id = top.id";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			try(ResultSet rs = stmt.executeQuery()) {
				while(rs.next()) {
					Tutorial tutorial = new Tutorial();
					tutorial.setId(rs.getInt("id"));
					tutorial.setName(rs.getString("name"));
					tutorial.setAuthor(rs.getString("author"));
					tutorial.setPublishDate(rs.getDate("publish_date"));
					tutorial.setVisits(rs.getInt("visits"));
					tutorial.setContents(rs.getString("contents"));
					tutorial.setTopicId(rs.getInt("topic_id"));
					tutorial.setTopic(rs.getString("topic_name"));
					list.add(tutorial);
				}
			}
		}
		return list;
	}

	public int incrementTutorialVisits(int tutorialId) throws Exception {
		String sql = "UPDATE tutorials SET visits = visits + 1 WHERE id = ?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, tutorialId);
			return stmt.executeUpdate();
		}
	}
}

