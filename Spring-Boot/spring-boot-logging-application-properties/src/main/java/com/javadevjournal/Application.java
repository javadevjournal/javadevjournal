package com.javadevjournal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) {

        LOG.debug("debug message");
        LOG.info("This is an info message");
        LOG.warn("Warning for this application");
        LOG.error("Seems some error in the application");
        SpringApplication.run(Application.class, args);
    }

}

