package com.javadevjournal.service.customer;

import com.javadevjournal.data.customer.Customer;
import org.springframework.stereotype.Service;

@Service("customerService")
public class DefaultCustomerService implements CustomerService {

    @Override
    public Customer getCustomerById(String id) {
        return new Customer("Test","Customer",id,"contact-us@javadevjournal.com");
    }
}
