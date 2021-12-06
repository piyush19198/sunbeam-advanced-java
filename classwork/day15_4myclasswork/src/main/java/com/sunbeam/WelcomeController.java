package com.sunbeam;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {
	@GetMapping("/hello")
	public @ResponseBody String sayHello() {
		return "Hello, World!";
	}
	
	@GetMapping("/student")
	public @ResponseBody Student getStudent() {
		Student result = new Student(101, "Nilesh Ghule", "Sunbeam");
		return result;
	}
	
	@GetMapping("/students")
	public @ResponseBody List<Student> getStudents() {
		List<Student> list = new ArrayList<>();
		list.add(new Student(101, "Nilesh Ghule", "Sunbeam"));
		list.add(new Student(202, "Nitin Kudale", "Sunbeam"));
		return list;
	}
}


