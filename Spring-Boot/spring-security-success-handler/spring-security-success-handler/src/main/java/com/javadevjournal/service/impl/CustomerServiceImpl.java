package com.javadevjournal.service.impl;

import com.javadevjournal.data.CustomerData;
import com.javadevjournal.jpa.entities.CustomerEntity;
import com.javadevjournal.jpa.repository.CustomerRepository;
import com.javadevjournal.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public CustomerEntity saveCustomer(final CustomerData customerData){
        CustomerEntity customerModel = populateCustomerData(customerData);
        return customerRepository.save(customerModel);
    }

    private CustomerEntity populateCustomerData(final CustomerData customerData){
        CustomerEntity customer = new CustomerEntity();
        customer.setFirstName(customerData.getFirstName());
        customer.setLastName(customerData.getLastName());
        customer.setEmail(customerData.getEmail());
        customer.setPassword(passwordEncoder.encode(customerData.getPassword()));
        return customer;
    }
}
