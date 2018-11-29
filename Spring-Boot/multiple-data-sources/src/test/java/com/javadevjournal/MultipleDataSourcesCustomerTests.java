package com.javadevjournal;

import com.javadevjournal.customer.config.CustomerConfig;
import com.javadevjournal.customer.data.CustomerModel;
import com.javadevjournal.customer.repo.CustomerRepository;
import com.javadevjournal.product.config.ProductConfig;
import com.javadevjournal.product.data.ProductModel;
import com.javadevjournal.product.repo.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultipleDataSourcesCustomerTests {


    @Autowired
    private CustomerRepository customerRepository;

    @Test
    @Transactional("customerTransactionManager")
    public void create_check_customer() {

        CustomerModel customer = new CustomerModel("user@javadevjournal.com","Robert","Hickle");
        customer = customerRepository.save(customer);

        assertNotNull(customerRepository.findById(customer.getId()));
        assertEquals(customerRepository.findById(customer.getId()).get().getEmail() ,"user@javadevjournal.com");
    }
}
