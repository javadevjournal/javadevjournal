package com.javadevjournal;

import com.javadevjournal.service.DefaultHelloService;
import com.javadevjournal.service.HelloService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

@SpringBootApplication
public class SpringBootStandaloneApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStandaloneApplication.class, args);
    }

    @Bean
    public HelloService getHelloService(){
        return  new DefaultHelloService();
    }

    @Override
    public void run(String... args) throws Exception {
        getHelloService().hello();
    }
}
