package com.javadevjournal.customlogout.core.config;

import com.javadevjournal.customlogout.core.entity.UserEntity;
import com.javadevjournal.customlogout.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class CustomLogoutHandler implements LogoutHandler {

	@Autowired
	UserService userService;

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response,
					   Authentication authentication) {
		SecurityContextHolder.clearContext();

		try {
			final UserEntity userEntity = userService.findUserByUsername(authentication.getName());
			System.out.println("Logged Out Handler");
			//set status to false
			userEntity.setStatus(false);
			userService.saveUser(userEntity);
			//redirecting to another controller endpoint
			response.sendRedirect("/perform-logout");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
