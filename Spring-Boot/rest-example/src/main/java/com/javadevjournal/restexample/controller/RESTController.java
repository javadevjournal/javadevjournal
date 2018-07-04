package com.javadevjournal.restexample.controller;

import com.javadevjournal.restexample.data.Customer;
import com.javadevjournal.restexample.jpa.CustomerRepository;
import com.javadevjournal.restexample.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RESTController {

    @Autowired
    private CustomerService customerService;

    @PutMapping("/customers/{id}")
    public ResponseEntity<?> saveResource(@RequestBody Customer customer,
                                          @PathVariable("id") String id) {
        Customer newCustomer = customerService.saveCustomer(customer,id);
        return new ResponseEntity<>(newCustomer,HttpStatus.OK);
    }

    @PatchMapping("/customers/{id}")
    public ResponseEntity<?> updateResource(@RequestParam("email") String email, @PathVariable("id") String id){
        Customer newCustomer = customerService.updateCustomer(email,id);
        return new ResponseEntity<>(newCustomer,HttpStatus.OK);
    }
}
