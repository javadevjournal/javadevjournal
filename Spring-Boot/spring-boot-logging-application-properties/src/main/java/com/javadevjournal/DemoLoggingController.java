package com.javadevjournal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoLoggingController {
    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    @GetMapping(value = "/")
    public String test(){

        LOG.debug("debug message");
        LOG.info("This is an info message");
        LOG.warn("Warning for this application");
        LOG.error("Seems some error in the application");
        return "test";
    }
}
