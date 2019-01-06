package com.javadevjournal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class SpringManagedBeansApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringManagedBeansApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext applicationContext) {
        return args -> {
            String[] beanNames = applicationContext.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String bean : beanNames) {
                System.out.println(bean);
                System.out.println(applicationContext.getBean(bean).getClass());
            }
        };
    }
}

