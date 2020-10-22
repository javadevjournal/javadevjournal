package com.javadevjournal.service.impl;

import com.javadevjournal.data.Customer;
import com.javadevjournal.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * We are replying on the default configuration and let the spring boot
 * defaults to choose the cache provider for us
 */
@Service
public class DefaultCustomerService implements CustomerService {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultCustomerService.class);

    /**
     * @param id
     * @return Customer
     */
    @Cacheable(cacheNames = "customers")
    @Override
    public Customer getCustomer(Long id) {
        LOG.info("Fetching customer information for Id {} ", id);
        Customer customer = new Customer();
        customer.setEmail("contact-us@javadevjournal.com");
        customer.setFirstName("Javadev");
        customer.setLastName("Journal");
        customer.setId(id);
        return customer;
    }

    @Override
    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        for(int i =1 ; i < 4; i++){
            Customer customer = new Customer();
            customer.setEmail("contact-us@javadevjournal.com"+i);
            customer.setFirstName("Javadev");
            customer.setLastName("Journal");
            customer.setId(i);
            customers.add(customer);
        }
        return customers;
    }
}
