package com.sunbeam.beans;

import java.util.ArrayList;
import java.util.List;

import com.sunbeam.daos.TutorialDaoImpl;
import com.sunbeam.pojos.Tutorial;

public class TopicTutorialsBean {
	private int topicId;
	private List<Tutorial> tutorialList;
	
	public TopicTutorialsBean() {
		this.tutorialList = new ArrayList<>();
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public List<Tutorial> getTutorialList() {
		return tutorialList;
	}

	public void setTutorialList(List<Tutorial> tutorialList) {
		this.tutorialList = tutorialList;
	}
	
	public void fetchTopicTutorials() {
		try(TutorialDaoImpl dao = new TutorialDaoImpl()) {
			this.tutorialList = dao.getTutorials(this.topicId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}