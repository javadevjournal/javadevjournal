package com.javadevjournal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;

@SpringBootApplication
public class GsonSpringBootApplication {

    public static void main(String[] args) {

        SpringApplication.run(GsonSpringBootApplication.class, args);
    }

}

