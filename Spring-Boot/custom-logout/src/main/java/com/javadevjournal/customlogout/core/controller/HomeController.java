package com.javadevjournal.customlogout.core.controller;

import com.javadevjournal.customlogout.core.entity.UserEntity;
import com.javadevjournal.customlogout.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class HomeController {
	@Autowired
	UserService userService;
	@GetMapping("/home")
	public String welcome() {
		UserEntity userEntity = userService.findUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		userEntity.setStatus(true);
		userService.saveUser(userEntity);
		return "home";
	}

	@GetMapping("/admin")
	public String admin(){
		return "admin";
	}

}
