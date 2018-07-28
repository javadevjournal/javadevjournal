package com.javadevjournal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomFaviconController {

    @GetMapping("/greeting")
    public String greeting(){
        return "demo";
    }


}



