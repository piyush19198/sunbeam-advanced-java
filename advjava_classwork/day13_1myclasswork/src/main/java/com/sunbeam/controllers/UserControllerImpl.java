package com.sunbeam.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunbeam.pojos.Credentials;
import com.sunbeam.pojos.User;
import com.sunbeam.services.UserServiceImpl;

@Controller
public class UserControllerImpl {
	private UserServiceImpl userService;
	// @Autowired
	public UserControllerImpl(UserServiceImpl userService) {
		this.userService = userService;
	}

	@RequestMapping("/login") // req url -- /login
	public String login() {
		return "login"; // view name -- login -- .jsp
	}
	
	@RequestMapping("/validate")
	public String validate(Credentials cred) {
		User user = userService.authenticateUser(cred.getEmail(), cred.getPassword());
		if(user == null)
			return "failed";
		if(user.getRole().equals("admin"))
			return "manage";
		return "topics";
	}
}


