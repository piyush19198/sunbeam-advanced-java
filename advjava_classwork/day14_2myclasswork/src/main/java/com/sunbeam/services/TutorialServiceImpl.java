package com.sunbeam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.TopicDaoImpl;
import com.sunbeam.daos.TutorialDaoImpl;
import com.sunbeam.pojos.Topic;
import com.sunbeam.pojos.Tutorial;

@Service
public class TutorialServiceImpl {
	@Autowired
	private TopicDaoImpl topicDao;
	@Autowired
	private TutorialDaoImpl tutorialDao;
	
	public List<Topic> findAllTopics() {
		return topicDao.findAll();
	}
	
	public List<Tutorial> findAllTutorials() {
		return tutorialDao.findAll();
	}
	
	public List<Tutorial> findTopicTutorials(int topicId) {
		return tutorialDao.findByTopicId(topicId);
	}
	
	public Tutorial findTutorialById(int tutorialId) {
		return tutorialDao.findById(tutorialId);
	}
	
	public int incrementTutorialVisitCount(int tutorialId) {
		return tutorialDao.incrementTutorialVisitCount(tutorialId);
	}

	public int save(Tutorial tutorial) {
		return tutorialDao.save(tutorial);
	}
}

