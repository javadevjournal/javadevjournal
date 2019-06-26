package com.javadevjournal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class IndividualHeaderController {

    private static final Logger LOG= LoggerFactory.getLogger(IndividualHeaderController.class);

    @GetMapping("/products/product/{code}")
    public String getProduct(@PathVariable("code") String code, @RequestHeader("accept-language") String language){
        //logic based on the header value
        LOG.info("Accepted language is {}", language);
        return "DemoProduct";
    }
}
