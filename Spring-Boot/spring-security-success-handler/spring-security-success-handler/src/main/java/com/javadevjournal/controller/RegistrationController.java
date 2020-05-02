package com.javadevjournal.controller;

import com.javadevjournal.data.CustomerData;
import com.javadevjournal.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    private static final String REGISTRATION_CONFIRMATION_PAGE ="registrationConfirmation";

    @Autowired
    private CustomerService customerService;

    @GetMapping("/register")
    public String getRegistrationView(){
        return "registration";
    }

    @PostMapping("/register")
    public String customerRegistration(final CustomerData customer, final Model model){
        customerService.saveCustomer(customer);
        return REGISTRATION_CONFIRMATION_PAGE;
    }
}
