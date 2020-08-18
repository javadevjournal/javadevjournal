package com.javadevjournal.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginPageController {

    @GetMapping
    public String login(@RequestParam(value = "error",defaultValue = "false") boolean loginError){
        if(loginError){
            // do whatever you want to 
        }
        return "account/login";
    }

}
