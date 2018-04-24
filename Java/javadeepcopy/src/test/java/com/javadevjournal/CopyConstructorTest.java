package com.javadevjournal;

import com.javadevjournal.data.Customer;
import com.javadevjournal.data.Order;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class CopyConstructorTest {

    @Test
    public void testCopyConstructor(){

        Order order = new Order("12345", 100.45, "In Progress");
        Customer customer = new Customer("Test", "CUstomer", order);
        Customer customerCopy = new Customer(customer);

        order.setOrderStatus("Shipped");
        assertNotEquals(customer.getOrder().getOrderStatus(), customerCopy.getOrder().getOrderStatus());
    }
}
