package com.javadevjournal.customlogout.core.controller;

import com.javadevjournal.customlogout.core.entity.UserEntity;
import com.javadevjournal.customlogout.core.repository.UserRepository;
import com.javadevjournal.customlogout.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {
	private static final String REGISTRATION_CONFIRMATION_PAGE ="registrationConfirmation";

	@Autowired
	private UserService  userService;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/register")
	public String getRegistration(){
		return "registration";
	}

	@PostMapping("/register")
	public String registration(final UserEntity userEntity, final Model model){
		userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
		userService.saveUser(userEntity);
		return REGISTRATION_CONFIRMATION_PAGE;
	}

	@GetMapping("/perform-logout")
	public String logout(final Model model) {
		System.out.println("Loggingout");
		return "login";
	}

	@GetMapping("/login")
	public String login(final Model model) {
		System.out.println("Log in");
		return "login";
	}


}
