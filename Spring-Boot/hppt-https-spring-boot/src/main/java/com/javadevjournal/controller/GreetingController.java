package com.javadevjournal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping(value = "/greeting")
    public String greeting(){
        return "I am working with both HTTP and HTTPS";
    }
}
