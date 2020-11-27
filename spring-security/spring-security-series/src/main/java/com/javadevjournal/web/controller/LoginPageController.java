package com.javadevjournal.web.controller;

import com.javadevjournal.web.data.user.ResetPasswordData;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginPageController {

    @GetMapping
    public String login(@RequestParam(value = "error",defaultValue = "false") boolean loginError, @RequestParam(value = "invalid-session", defaultValue = "false") boolean invalidSession, final Model model){
        if(loginError){
            // do whatever you want to 
        }
        if(invalidSession){
            model.addAttribute("invalidSession", "It seems you are trying to login from multiple locations. For security reasons, we only allow 1 login");
        }
        model.addAttribute("forgotPassword", new ResetPasswordData());
        return "account/login";
    }

}
