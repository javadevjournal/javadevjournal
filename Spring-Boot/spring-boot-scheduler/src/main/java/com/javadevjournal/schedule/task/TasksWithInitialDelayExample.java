package com.javadevjournal.schedule.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TasksWithInitialDelayExample {

    private static final Logger LOG = LoggerFactory.getLogger(TasksWithInitialDelayExample.class);

    @Scheduled(fixedRate = 2000, initialDelay = 5000)
    public void scheduleTaskWithInitialDelay() {
        LOG.info("Fixed Rate Task with Initial Delay");
    }
}
