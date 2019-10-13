package com.javadevjournal;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
public class CustomThreadPoolConfig implements SchedulingConfigurer {

    private final int CUSTOM_POOL_SIZE = 5;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {

        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(CUSTOM_POOL_SIZE);
        threadPoolTaskScheduler.setThreadNamePrefix("javadevjournal");
        threadPoolTaskScheduler.initialize();

        //let's register our custom thread pool scheduler
        scheduledTaskRegistrar.setTaskScheduler(threadPoolTaskScheduler);
    }
}
