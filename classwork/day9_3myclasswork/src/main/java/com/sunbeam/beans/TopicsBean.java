package com.sunbeam.beans;

import java.util.ArrayList;
import java.util.List;

import com.sunbeam.daos.TutorialDaoImpl;
import com.sunbeam.pojos.Topic;

public class TopicsBean {
	private List<Topic> topicList;
	
	public TopicsBean() {
		this.topicList = new ArrayList<>();
	}
	public List<Topic> getTopicList() {
		return topicList;
	}
	public void setTopicList(List<Topic> topicList) {
		this.topicList = topicList;
	}
	public void fetchTopics() {
		try(TutorialDaoImpl dao = new TutorialDaoImpl()) {
			this.topicList = dao.getTopics();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}