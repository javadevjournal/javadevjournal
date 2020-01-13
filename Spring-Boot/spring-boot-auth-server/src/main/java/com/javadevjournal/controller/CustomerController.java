package com.javadevjournal.controller;

import com.javadevjournal.data.CustomerData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @GetMapping("/customer/{userId}")
    public CustomerData getCustomerProfile(@PathVariable("userId") String userId) {
        return getCustomer(userId);
    }

    private CustomerData getCustomer(final String userId) {
        CustomerData customer = new CustomerData();
        customer.setEmail("contact-us@javadevjournal.com");
        customer.setFirstName("Demo");
        customer.setLastName("User");
        customer.setAge(21);
        customer.setId(userId);
        return customer;
    }
}
