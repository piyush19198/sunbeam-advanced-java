package com.sunbeam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sunbeam.pojos.Topic;
import com.sunbeam.pojos.User;
import com.sunbeam.services.TutorialServiceImpl;
import com.sunbeam.services.UserServiceImpl;

@SpringBootApplication
public class Day122myclassworkApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Day122myclassworkApplication.class, args);
	}
	
	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private TutorialServiceImpl tutorialService;

	@Override
	public void run(String... args) throws Exception {
		User user1 = userService.findByEmail("rama@gmail.com");
		System.out.println("User1 : " + user1);

		User user2 = userService.authenticateUser("rama@gmail.com", "1234");
		System.out.println("User2 : " + user2);
	
		List<Topic> topicList = tutorialService.findAllTopics();
		topicList.forEach(System.out::println);
		
		// test remaining methods in tutorialService
	}
}
