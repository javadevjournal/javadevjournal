package com.javadevjournal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class SessionListenerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SessionListenerApplication.class, args);
	}
}
