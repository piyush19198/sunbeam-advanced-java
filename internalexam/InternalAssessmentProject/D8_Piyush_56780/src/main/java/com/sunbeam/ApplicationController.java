package com.sunbeam;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sunbeam.pojos.Credential;
import com.sunbeam.pojos.Vendor;
import com.sunbeam.services.VendorServiceImpl;

@Controller
public class ApplicationController {
	@Autowired
	VendorServiceImpl vendorService;

	public ApplicationController(VendorServiceImpl vendorService) {
		super();
		this.vendorService = vendorService;
	}

	@RequestMapping("/welcome")
	public String home(Model model) {
		return "index";
	}

	@RequestMapping("/login")
	public String login(Model model) {
		Credential cred = new Credential("guest@gmail.com", "");
		model.addAttribute("command", cred);
		return "login";
	}

	@RequestMapping("/validate")
	public String validate(Credential cred, HttpSession session) {
		Vendor v = vendorService.authenticateVendor(cred.getEmail(), cred.getPassword());
		session.setAttribute("vendor", v);
		if (v == null) {
			return "failed";
		}
		if (v.getRole().equals("admin"))
			return "redirect:admin";
		return "vendorList";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session, Model model) {
		Vendor v = (Vendor) session.getAttribute("vendor");
		model.addAttribute("vendor", v);
		session.invalidate();
		return "logout";
	}

	@RequestMapping("/admin")
	public String validate(Model model) {
		List<Vendor> allVendors = vendorService.getAdminContents();
		model.addAttribute("allVendors", allVendors);
		return "admin";
	}

	@RequestMapping("/updateVendor")
	public String updateVendorDetails(@RequestParam("id") int id, Model model) {
		Vendor vendor = vendorService.getVendorDetails(id);
		model.addAttribute("vendor", vendor);
		return "updateVendor";
	}

	@RequestMapping("/update")
	public String update(@RequestParam("city") String city, @RequestParam("cellNo") String cellNo,
			@RequestParam("id") int id, Model model) {
		int exec = vendorService.updateVendor(city, cellNo, id);
		model.addAttribute("updatedRow", exec);
		return "redirect:admin";
	}

	@RequestMapping("/deleteVendor")
	public String delete(@RequestParam("id") int id, Model model) {
		int exec = vendorService.deleteVendor(id);
		model.addAttribute("deletedRow", exec);
		return "redirect:admin";
	}

	@RequestMapping("/addVendor")
	public String addvendor(){
		return "addVendor";
	}

	@PostMapping("/add")
	public String add(@RequestParam("name") String name ,@RequestParam("email") String email ,@RequestParam("password") String password ,@RequestParam("city") String city,@RequestParam("cellNo") String cellNo,@RequestParam("regAmount") double regAmount,@RequestParam("date") Date date,@RequestParam("role") String role) {
		int exec = vendorService.addVendor(name, email, password, city, cellNo, regAmount, date, role);
		return "redirect:admin";
	}
}