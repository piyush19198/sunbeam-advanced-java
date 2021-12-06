package com.sunbeam;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping({"/", "/index"})
	public String home(Model model) {
		model.addAttribute("curTime", new Date().toString());
		return "home"; // --> thymeleaf template -- home.html
	}
}

