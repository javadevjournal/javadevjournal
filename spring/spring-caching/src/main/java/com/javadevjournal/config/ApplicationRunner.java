package com.javadevjournal.config;

import com.javadevjournal.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationRunner.class);

    @Autowired
    private ProductService productService;

    @Override
    public void run(String... args) throws Exception {
        logger.info("############### Getting product List ###################### ");
        //Test getProducts method using caching
        logger.info("get all products Test 1 -->" + productService.getProducts());

        // Pay attention to the time taken to fetch products in 2nd and 3rd attempt
        logger.info("get all products Test 2 -->" + productService.getProducts());
        logger.info("get all products Test 3 -->" + productService.getProducts());

        //Custom Cache annotation example
        logger.info("############### Getting product by code ###################### ");
        logger.info("product detail Test 1 -->" + productService.getProduct("12345"));

        // Pay attention to the time taken to fetch products in 2nd and 3rd attempt
        logger.info("product detail Test 1 -->" + productService.getProduct("54321"));
        logger.info("product detail Test 1 -->" + productService.getProduct("12345"));

        logger.info("product detail Test 1 -->" + productService.getProduct("54321"));
        logger.info("product detail Test 1 -->" + productService.getProduct("12345"));
    }
}
