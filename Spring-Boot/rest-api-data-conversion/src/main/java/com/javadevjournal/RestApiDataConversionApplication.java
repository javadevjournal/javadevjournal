package com.javadevjournal;

import com.javadevjournal.rest.facade.OrderFacade;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestApiDataConversionApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApiDataConversionApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper(){
        return  new ModelMapper();
    }

    @Bean
    public OrderFacade orderFacade(){
        return  new OrderFacade();
    }
}
