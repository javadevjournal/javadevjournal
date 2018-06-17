package com.javadevjournal.rest;

import com.javadevjournal.rest.jpa.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestPagninationWithSpringApplication {


    public static void main(String[] args) {
        SpringApplication.run(RestPagninationWithSpringApplication.class, args);
    }
}
