package com.javadevjournal.web.controller.api;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/users")
public class UserRestAPI {

    @GetMapping("/hello")
    public String getData(){
        return "hello";
    }

    @Secured({"ROLE_CUSTOMER", "ROLE_USER"})
    @PreAuthorize("hasRole('ROLE_CUSTOMER') or hasRole('ROLE_ADMIN')")
    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable String id){
        return "id";
    }
}
