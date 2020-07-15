package com.javadevjournal.controller;

import com.javadevjournal.customer.service.CustomerService;
import com.javadevjournal.data.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customer/{id}")
    public CompletableFuture<Customer> getCustomerById(@PathVariable String id) throws InterruptedException {
        return customerService.getCustomerByID(id);
    }

    @PostMapping("/customer/update")
    public void updateCustomer() throws Exception {
        customerService.updateCustomer(null);
    }

    @GetMapping("/customer/id/{email}")
    public Customer getCustomerByEmail(@PathVariable String email) throws InterruptedException {
        return customerService.getCustomerByEmail(email);
    }
}
