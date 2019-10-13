package com.javadevjournal.schedule.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class FixedDelayTaskExample {

    private static final Logger LOG = LoggerFactory.getLogger(FixedDelayTaskExample.class);

    @Scheduled(fixedDelay = 2000)
    public void fixedDelayExample() {
        LOG.info("Hello from our Fixed delay method");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException ie) {
            LOG.error("Got Interrupted {}", ie);
        }
    }
}
