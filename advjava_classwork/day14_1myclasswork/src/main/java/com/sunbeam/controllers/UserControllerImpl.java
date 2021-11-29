package com.sunbeam.controllers;

import java.util.Enumeration;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunbeam.pojos.AuthenticatedUser;
import com.sunbeam.pojos.Credentials;
import com.sunbeam.pojos.User;
import com.sunbeam.services.UserServiceImpl;

@Controller
public class UserControllerImpl {
	private UserServiceImpl userService;
	@Autowired
	private AuthenticatedUser authUser;
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
	public String validate(Credentials cred) {
		User user = userService.authenticateUser(cred.getEmail(), cred.getPassword());
		if(user == null)
			return "failed";
		
		System.out.println("authUser Class: " + authUser.getClass().getName());
		authUser.setId(user.getId());
		authUser.setName(user.getName());
		authUser.setEmail(user.getEmail());
		authUser.setRole(user.getRole());
		
		if(user.getRole().equals("admin"))
			return "redirect:manage";	// --> resp.sendRedirect("manage");
		return "redirect:topicsurl";	// --> resp.sendRedirect("topics"); --> TutorialController.topics()
		// return "forward:topics"; // --> req.getRequestDispatcher("topics").forward(request, response);
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		Enumeration<String> attrNames = session.getAttributeNames();
		while (attrNames.hasMoreElements()) {
			String attrName = (String) attrNames.nextElement();
			Object attrValue = session.getAttribute(attrName);
			System.out.println(authUser.getName() + " session : " + attrName + " --> " + attrValue);
		}
		session.invalidate();
		return "logout";
	}
}


