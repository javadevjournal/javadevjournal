package com.javadevjournal.userepoql;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserepoqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserepoqlApplication.class, args);
	}
	
	@Bean
	ApplicationRunner init(UserService userService) {
		return args -> {
			Stream.of(
					"javadevjournal:Java Dev Journal", 
					"octocat:The Octocat", 
					"guest:From Another Universe"
			).forEach( data -> {
				User u = new User();
				String[] fields = data.split(":"); 
				u.setLogin(fields[0]);
				u.setName(fields[1]);
				userService.saveUser(u);
			});
			userService.getAllUsers().forEach(System.out::println);
		};
	}
}
