package com.javadevjournal.userepoql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

@Component
public class Mutation implements GraphQLMutationResolver {
	
	@Autowired
	private UserService userService;

	public User createUser(String login, String name) {
		return this.userService.newUser(login, name);
	}
}
