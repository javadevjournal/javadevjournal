package com.javadevjournal;

import com.javadevjournal.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CaffeineCacheApp implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(CaffeineCacheApp.class);

    @Autowired
    CustomerService customerService;

    @Override
    public void run(String... args) throws Exception {

        LOG.info("Starting the Caffine cache testing process");
        customerService.getCustomer(1l) ; //No hit , since this is the first request.
        customerService.getCustomer(2l) ; //No hit , since this is the first request.
        customerService.getCustomer(1l) ; //hit , since it is already in the cache.
        customerService.getCustomer(1l) ; //hit , since it is already in the cache.
        customerService.getCustomer(1l) ; //hit , since it is already in the cache.
        customerService.getCustomer(1l) ; //hit , since it is already in the cache.
    }
}
