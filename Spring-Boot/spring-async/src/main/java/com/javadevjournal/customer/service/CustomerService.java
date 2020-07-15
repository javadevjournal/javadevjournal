package com.javadevjournal.customer.service;

import com.javadevjournal.data.customer.Customer;

import java.util.concurrent.CompletableFuture;

public interface CustomerService {

    CompletableFuture<Customer> getCustomerByID(final String id) throws InterruptedException;
    void updateCustomer(final Customer customer) throws Exception;
    Customer getCustomerByEmail(final String email) throws InterruptedException;
}
