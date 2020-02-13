package com.javadevjournal.service;

import com.javadevjournal.dto.CustomerData;

import java.util.List;

public interface CustomerService {

    CustomerData saveCustomer(CustomerData customer);
    boolean deleteCustomer(final Long customerId);
    List<CustomerData> getAllCustomers();
    CustomerData getCustomerById(final Long customerId);
}
