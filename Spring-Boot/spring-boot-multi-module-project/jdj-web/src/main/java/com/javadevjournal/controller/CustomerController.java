package com.javadevjournal.controller;

import com.javadevjournal.data.customer.Customer;
import com.javadevjournal.service.customer.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Resource(name = "customerService")
    CustomerService customerService;

    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable String id){
        return customerService.getCustomerById(id);
    }
}
