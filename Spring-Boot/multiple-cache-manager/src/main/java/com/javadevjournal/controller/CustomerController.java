package com.javadevjournal.controller;

import com.javadevjournal.data.Customer;
import com.javadevjournal.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    CacheManager cacheManager;

    @GetMapping("/customer/{id}")
    public Customer getCustomerByID(@PathVariable(value = "id") Long id){
        Customer customer =  customerService.getCustomer(id);
       cacheManager.getCacheNames();
        return customer;
    }
}
