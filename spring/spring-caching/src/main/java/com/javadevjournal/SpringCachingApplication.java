package com.javadevjournal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringCachingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCachingApplication.class, args);
    }
}
