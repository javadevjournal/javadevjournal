package com.javadevjournal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Log4J2Controller {

    private static final Logger LOG = LogManager.getLogger(Log4J2Controller.class);

    @GetMapping(value = "/greeting")
    public String greeting() {

        LOG.debug("Debugging log in our greeting method");
        LOG.info("Info log in our greeting method");
        LOG.warn("Warning log in our greeting method");
        LOG.error("Error in our greeting method");
        return "Hello!!!";
    }
}
