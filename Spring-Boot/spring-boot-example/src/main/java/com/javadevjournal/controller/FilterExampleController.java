package com.javadevjournal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterExampleController {

    @GetMapping
    public String greeting(){
        return "Hello World";
    }

    @GetMapping(value = "/greeting")
    public String customGreetings(){
        return "Hello From Custom Greetings";
    }
}
