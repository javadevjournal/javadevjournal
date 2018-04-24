package com.javadevjournal;

import com.javadevjournal.data.Customer;
import com.javadevjournal.data.Order;
import org.apache.commons.lang3.SerializationUtils;

public class SerializationUtilsExample {

    public void deepClone(Order order, Customer customer){

        Customer cloneCustomer = SerializationUtils.clone(customer);
    }
}
