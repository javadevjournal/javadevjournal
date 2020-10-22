package com.javadevjournal.service;

import com.javadevjournal.data.Customer;

import java.util.List;

public interface CustomerService {

    Customer getCustomer(final Long id);
    List<Customer> getCustomers();
}
