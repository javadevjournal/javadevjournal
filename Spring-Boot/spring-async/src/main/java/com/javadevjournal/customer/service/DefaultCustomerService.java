package com.javadevjournal.customer.service;

import com.javadevjournal.data.customer.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class DefaultCustomerService implements CustomerService {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultCustomerService.class);

    @Override
    @Async("threadPoolTaskExecutor")
    public CompletableFuture<Customer> getCustomerByID(final String id) throws InterruptedException {
        LOG.info("Filling the customer details for id {} ", id);
        Customer customer = new Customer();
        customer.setFirstName("Javadev");
        customer.setLastName("Journal");
        customer.setAge(34);
        customer.setEmail("contact-us@javadevjournal");
        // doing an artificial sleep
        Thread.sleep(20000);
        return CompletableFuture.completedFuture(customer);
    }

    @Override
    @Async("threadPoolTaskExecutor")
    public void updateCustomer(Customer customer) throws Exception {
        LOG.warn("Running method with thread {} :", Thread.currentThread().getName());
        throw new Exception("Throw exception to check the custom exception handling");
    }

    @Override
    public Customer getCustomerByEmail(String email) throws InterruptedException {
        LOG.info("Filling the customer details for email {} ", email);
        Customer customer = new Customer();
        customer.setFirstName("New");
        customer.setLastName("Customer");
        customer.setAge(30);
        customer.setEmail("contact-us@javadevjournal");
        Thread.sleep(20000);
        return customer;
    }
}
