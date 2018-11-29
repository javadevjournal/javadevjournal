package com.javadevjournal;

import com.javadevjournal.customer.data.CustomerModel;
import com.javadevjournal.customer.repo.CustomerRepository;
import com.javadevjournal.product.data.ProductModel;
import com.javadevjournal.product.repo.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultipleDataSourcesProductTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    @Transactional("productTransactionManager")
    public void create_check_product() {
        ProductModel product = new ProductModel("228781","Running Shoes", 20.0);
        product = productRepository.save(product);

        assertNotNull(productRepository.findById(product.getId()));
    }

}
