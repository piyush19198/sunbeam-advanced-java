package com.sunbeam;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	@RequestMapping("/welcome") 		// welcome: request handler url
	public String home(Model model) {	// home(): request handler method
		Date now = new Date();
		model.addAttribute("curTime", now);	// --> request.setAttribute("curTime", now);
		return "index";					// index: view name
	}
}

