package com.javadevjournal.schedule.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FixedRateScheduledTask {

    private static final Logger LOG = LoggerFactory.getLogger(FixedRateScheduledTask.class);

    @Scheduled(fixedRate = 1000)
    public void sayHello() {
        LOG.info("Hello from our simple scheduled method");

    }
}
