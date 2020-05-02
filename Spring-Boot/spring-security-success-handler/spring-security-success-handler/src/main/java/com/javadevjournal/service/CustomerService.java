package com.javadevjournal.service;

import com.javadevjournal.data.CustomerData;
import com.javadevjournal.jpa.entities.CustomerEntity;

public interface CustomerService {
    CustomerEntity saveCustomer(final CustomerData customerData);
}
