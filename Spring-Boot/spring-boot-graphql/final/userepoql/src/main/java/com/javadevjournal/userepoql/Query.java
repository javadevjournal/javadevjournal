package com.javadevjournal.userepoql;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class Query implements GraphQLQueryResolver {
	private UserService userService ;
	
	public Query(UserService userService) {
		this.userService = userService;
	}
	
	public List<User> getUsers(int first, int last) {
		System.out.println("Query: [" + first + "] to [" + last + "]");
		if((first == 0) && (last == 0)) {
			return this.userService.getAllUsers();
		} else {
			return this.userService.getUsers(first, last);
		}
	}
	
	public Optional<User> getUser(int id) {
		return this.userService.getUser(id);
	}
}
