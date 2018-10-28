package com.javadevjournal.repolister.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.javadevjournal.repolister.model.Repo;

@Service
public class UserService {
	private static final String search_url="https://api.github.com/users/%s/repos?page=1&per_page=5";
	
	@Autowired
	RestTemplate rt;
	
	public List<Repo> getResults(String user) {
		System.out.println("Invoking: " + String.format(search_url, user));
		Repo [] a = rt.getForEntity(String.format(search_url, user), Repo[].class).getBody();
		return Arrays.asList(a);
	}
}
