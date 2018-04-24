package com.javadevjournal;

import com.javadevjournal.data.Customer;
import com.javadevjournal.data.Order;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class SerializationUtilsTest {

    @Test
    public void testDeepClone(){

        Order order = new Order("12345", 100.45, "In Progress");
        Customer customer = new Customer("Test", "CUstomer", order);
        Customer cloneCustomer = SerializationUtils.clone(customer);

        order.setOrderStatus("Shipped");
        assertNotEquals(customer.getOrder().getOrderStatus(), cloneCustomer.getOrder().getOrderStatus());
    }
}
