package com.javadevjournal.springbootbatch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class SpringBootBatchBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBatchBasicApplication.class, args);
	}

}
