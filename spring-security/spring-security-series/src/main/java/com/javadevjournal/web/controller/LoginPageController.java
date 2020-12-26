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
    public String login(@RequestParam(value = "error",defaultValue = "false") boolean loginError,
                        @RequestParam(value = "invalid-session", defaultValue = "false") boolean invalidSession,
                        final Model model){
        if(loginError){
            // do whatever you want to 
        }
        if(invalidSession){
            model.addAttribute("invalidSession", "You already have an active session. We do not allow multiple active sessions");
        }
        model.addAttribute("forgotPassword", new ResetPasswordData());
        return "account/login";
    }

}
