package com.javadevjournal.service;

import com.javadevjournal.data.CustomerDto;
import com.javadevjournal.entity.CustomerEntity;
import com.javadevjournal.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("customerService")
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public CustomerEntity saveCustomer(final CustomerDto customerData){
        CustomerEntity customerModel = populateCustomerData(customerData);
       return customerRepository.save(customerModel);
    }

    private CustomerEntity populateCustomerData(final CustomerDto customerData){
        CustomerEntity customer = new CustomerEntity();
        customer.setFirstName(customerData.getFirstName());
        customer.setLastName(customerData.getLastName());
        customer.setEmail(customerData.getEmail());
        customer.setPassword(passwordEncoder.encode(customerData.getPassword()));
        return customer;
    }
}
