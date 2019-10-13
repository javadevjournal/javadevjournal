package com.javadevjournal.schedule.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CronExpressionTaskExample {

    private static final Logger LOG = LoggerFactory.getLogger(CronExpressionTaskExample.class);

    @Scheduled(cron = "0 * * * * ?")
    public void scheduleTaskWithCronExpression() {
        LOG.info("Example to show how cron expression can be used");
    }

}
