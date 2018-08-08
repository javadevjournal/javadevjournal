package com.javadevjournal.restexample.service;

import com.javadevjournal.restexample.data.Customer;
import com.javadevjournal.restexample.jpa.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DefaultCustomerService implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer, String id) {

        Optional<Customer> originalCustomer = customerRepository.findById(Long.valueOf(id));
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(String email, String id) {
        Optional<Customer> originalCustomer = customerRepository.findById(Long.valueOf(id));
        Customer customer = originalCustomer.get();
        customer.setEmail(email);
        return customerRepository.save(customer);
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
