package com.javadevjournal.web.controller.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GenericErrorHandler {

    @GetMapping("/invalid-session")
    public String invalidSession(){
        return "error/invalidSession";
    }
}
