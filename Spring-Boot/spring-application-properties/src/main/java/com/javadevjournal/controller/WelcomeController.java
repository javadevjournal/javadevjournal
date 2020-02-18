package com.javadevjournal.controller;

import com.javadevjournal.DefaultWelcomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class WelcomeController {

    private static final Logger LOG = LoggerFactory.getLogger(WelcomeController.class);

    @Resource
    private DefaultWelcomeService defaultWelcomeService;

    // We are injecting the configuration message from the application.properties file using @Value annotation
    @Value("${javadevjournal.welcome.message: Welcome!!!}")
    private String welcomeMsg;

    @Value("${javadevjournal.init.keys}")
    private int[] keys;

    @Value("${javadevjournal.init.keys}")
    private List<Integer> keyList;

    /**
     * Our Welcome display message which will use the welcome message property injected through the
     * @Value annotation.welcome
     * @return welcome message
     */
    @GetMapping("/welcome")
    public String displayWelcomeMsg(){
        LOG.info("keys as integer array {}", keys);
        LOG.info("keys as integer list {}", keyList);
       return defaultWelcomeService.getGreetingMessage();
    }
}
