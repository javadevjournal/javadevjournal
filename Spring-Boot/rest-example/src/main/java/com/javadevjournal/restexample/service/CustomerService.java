package com.javadevjournal.restexample.service;

import com.javadevjournal.restexample.data.Customer;

public interface CustomerService {

    public Customer saveCustomer(Customer customer, String id);
    public Customer updateCustomer(String email, String id);
    public Customer saveCustomer(Customer customer);
}
