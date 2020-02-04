package com.javadevjournal;

import com.javadevjournal.data.Customer;
import com.javadevjournal.exception.CustomRestServiceException;
import org.springframework.stereotype.Service;

@Service("customerService")
public class DefaultCustomerService {

    public Customer getCustomerById(final long customerId) throws CustomRestServiceException {
        if(customerId ==  1){
            throw new CustomRestServiceException("Service Exception");
        }
        return new Customer(customerId, "Test", "Customer","contact-us@javadevjournal.com");
    }

    public Customer registerCustomer(final Customer customer) throws CustomRestServiceException {

        //persist customer in the DB
        return customer;
    }
}
