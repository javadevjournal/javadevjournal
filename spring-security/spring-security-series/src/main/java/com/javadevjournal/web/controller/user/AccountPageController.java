package com.javadevjournal.web.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountPageController {

    @GetMapping("/starter")
    public String displayStarterPage(){
        return "generic/starter";
    }
}
