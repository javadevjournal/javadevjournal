package com.javadevjournal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SpringBootCaffeineApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCaffeineApplication.class, args);
	}

}
