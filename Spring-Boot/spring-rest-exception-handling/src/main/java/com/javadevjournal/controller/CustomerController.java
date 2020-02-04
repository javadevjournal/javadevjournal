package com.javadevjournal.controller;

import com.javadevjournal.DefaultCustomerService;
import com.javadevjournal.data.Customer;
import com.javadevjournal.exception.CustomRestServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    DefaultCustomerService customerService;

    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable long id) throws CustomRestServiceException {
        return customerService.getCustomerById(id);
    }

    @PostMapping("/customer/register")
    public Customer createCustomer(@Valid @RequestBody Customer customer) throws CustomRestServiceException {
        return customerService.registerCustomer(customer);
    }
}
