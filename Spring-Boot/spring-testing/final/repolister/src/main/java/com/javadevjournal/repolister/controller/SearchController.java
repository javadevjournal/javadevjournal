package com.javadevjournal.repolister.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javadevjournal.repolister.model.Repo;
import com.javadevjournal.repolister.service.UserService;

@RestController
@RequestMapping(value = "/top5")
public class SearchController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/{user}", method= RequestMethod.GET)
	public List<Repo> getInfo(@PathVariable(name="user") String user) {
		System.out.println("Querying for [" + user + "]");
		return userService.getResults(user);
	}
}
