package com.javadevjournal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class SessionDemoController {

    private static final Logger LOG = LoggerFactory.getLogger(SessionDemoController.class);

    @GetMapping("/get-session-count")
    public String testSessionListner(HttpServletRequest request, HttpServletResponse response){

        HttpSession session = request.getSession(false);
        if(session == null){
            LOG.info("Unable to find session. Creating a new session");
            session = request.getSession(true);
        }

        return "Session Test completed";
    }
}
