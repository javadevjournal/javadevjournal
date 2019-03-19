package com.javadevjournal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootChangeApplicationRootOrContextPathApplication {

	public static void main(String[] args) {
		//System.setProperty("server.servlet.context-path","/javadevjournal");
		SpringApplication.run(SpringBootChangeApplicationRootOrContextPathApplication.class, args);
	}

}
