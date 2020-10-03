package com.yusuf.travel.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.yusuf.travel.entity.User;
import com.yusuf.travel.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;

	@PostMapping("/user/registration")
	public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult errors, SessionStatus status) {
		 
		if(errors.hasErrors()) {
			return "registration";
		}else {
			userService.save(user);
		}
		status.setComplete();
		return "redirect:../index";
	}
}
