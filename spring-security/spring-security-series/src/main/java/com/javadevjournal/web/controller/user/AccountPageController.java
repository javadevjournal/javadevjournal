package com.javadevjournal.web.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountPageController {

    @GetMapping("/starter")
    public String displayStarterPage(){
        return "generic/starter";
    }
}
