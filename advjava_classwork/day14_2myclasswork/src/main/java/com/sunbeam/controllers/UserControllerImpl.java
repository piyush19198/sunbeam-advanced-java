package com.sunbeam.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	@RequestMapping({"/", "/login"}) // req url -- /login
	public String login(Model model) {
		Credentials cred = new Credentials("", "");
		model.addAttribute("command", cred); // command obj or modelAttribute or form backing bean
		return "login"; // view name -- login -- .jsp
	}
	
	@RequestMapping("/validate")
	public String validate(Credentials cred, HttpSession session) {
		User user = userService.authenticateUser(cred.getEmail(), cred.getPassword());
		if(user == null)
			return "failed";
		session.setAttribute("user", user);
		if(user.getRole().equals("admin"))
			return "redirect:manage";	// --> resp.sendRedirect("manage");
		return "redirect:topicsurl";	// --> resp.sendRedirect("topics"); --> TutorialController.topics()
		// return "forward:topics"; // --> req.getRequestDispatcher("topics").forward(request, response);
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "logout";
	}
}


