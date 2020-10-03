package com.yusuf.travel.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/index")
	public String getHome(HttpServletRequest request, Model model) {
		return "home";
	}
	
	@GetMapping("/registration")
	public String getRegistrationPage(HttpServletRequest request, Model model) {
		return "registration";
	}
}
