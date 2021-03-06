package com.sunbean.servicescontrollers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sunbean.entities.Credentials;
import com.sunbean.entities.Mobile;
import com.sunbean.entities.User;
import com.sunbean.services.MobileServices;
import com.sunbean.services.MobileServicesImpl;
import com.sunbean.services.UserServices;

@Controller
public class UserController {
	private UserServices uservice;
	private MobileServices mobservice;
	private MobileServicesImpl mobserviceimpl;
	
	@Autowired
	public UserController(UserServices uservice, MobileServices mobservice, MobileServicesImpl mobserviceimpl) {
		super();
		this.uservice = uservice;
		this.mobservice = mobservice;
		this.mobserviceimpl = mobserviceimpl;
	}

	public UserController() {
		super();
	}
	
	@RequestMapping("/welcome")
	public String index() {
		return "welcome";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/authenticate")
	public String authenticate(Credentials cred,HttpSession session) {
		User user = uservice.authenticate(cred.getEmail(),cred.getPassword());
		if(user!=null)
			return "redirect:details";
		return "error";
	}
	
	@RequestMapping("/details")
	public String mobileDetails(Credentials cred,Model model) {
		List<Mobile> list = mobservice.findByMobileId(cred.getId());
		model.addAttribute("MobileList",list);
		return "details";
	}
	
	@RequestMapping("/delete")
	public String delete (@RequestParam("id") int id) {
		mobservice.deleteById(id);
		return "redirect:details";
	}
	
	@RequestMapping("/add")
	public String add() {
		return "newdevice";
	}
	
	@RequestMapping("/addmobile")
	public String addMobile(Mobile mobile) {
		Mobile newDevice = mobservice.save(mobile);
		return "redirect:details";
	}
}
