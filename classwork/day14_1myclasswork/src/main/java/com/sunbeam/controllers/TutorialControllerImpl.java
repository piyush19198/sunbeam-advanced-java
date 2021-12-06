package com.sunbeam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sunbeam.pojos.AuthenticatedUser;
import com.sunbeam.pojos.Topic;
import com.sunbeam.pojos.TopicSelection;
import com.sunbeam.pojos.Tutorial;
import com.sunbeam.services.TutorialServiceImpl;

@Controller
public class TutorialControllerImpl {
	@Autowired
	private TutorialServiceImpl tutorialService;
	@Autowired
	private AuthenticatedUser authUser;

	@RequestMapping("/topicsurl")
	public String topics(Model model) {
		List<Topic> topicList = tutorialService.findAllTopics();
		model.addAttribute("topicList", topicList);
		int topicId = 0;
		if(!topicList.isEmpty())
			topicId = topicList.get(0).getId();
		TopicSelection topicSelect = new TopicSelection(topicId);
		model.addAttribute("command", topicSelect);
		model.addAttribute("uname", authUser.getName());
		return "topics"; // --> topics.jsp
	}
	
	/*
	@RequestMapping("/topictutorials")
	public String topicTutorials(TopicSelection topicSelect) {
		int topicId = topicSelect.getTopic();
		// ...
		return "topictutorials";
	}
	*/

	@RequestMapping("/topictutorials")
	public String topicTutorials(@RequestParam("topic") int topicId, Model model) {
		List<Tutorial> tutorialList = tutorialService.findTopicTutorials(topicId);
		model.addAttribute("tutorialList", tutorialList);
		model.addAttribute("uname", authUser.getName());
		return "topictutorials"; // --> topictutorials.jsp
	}
	
	@RequestMapping("/details")
	public String details(@RequestParam("id") int tutorialId, Model model) {
		Tutorial tutorial = tutorialService.findTutorialById(tutorialId);
		model.addAttribute("tutorial", tutorial);
		model.addAttribute("uname", authUser.getName());
		model.addAttribute("role", authUser.getRole());
		return "details"; // --> details.jsp
	}
}






