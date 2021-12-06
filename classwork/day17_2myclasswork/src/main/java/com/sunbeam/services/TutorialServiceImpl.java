package com.sunbeam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.daos.TopicDao;
import com.sunbeam.daos.TutorialDao;
import com.sunbeam.pojos.Topic;
import com.sunbeam.pojos.Tutorial;

@Transactional
@Service
public class TutorialServiceImpl {
	@Autowired
	private TopicDao topicDao;
	@Autowired
	private TutorialDao tutorialDao;
	
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
		Optional<Tutorial> tutorial = tutorialDao.findById(tutorialId);
		return tutorial.orElse(null);
	}
	
	public int incrementTutorialVisitCount(int tutorialId) {
		return tutorialDao.incrementTutorialVisitCount(tutorialId);
	}

	public int save(Tutorial tutorial) {
		Tutorial savedTutorial = tutorialDao.save(tutorial);
		return 1;
	}
}

