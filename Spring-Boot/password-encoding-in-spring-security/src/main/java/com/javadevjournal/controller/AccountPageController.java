package com.javadevjournal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountPageController {

    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
    }
}
