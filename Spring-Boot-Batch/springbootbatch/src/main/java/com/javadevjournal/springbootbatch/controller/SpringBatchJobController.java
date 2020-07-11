package com.javadevjournal.springbootbatch.controller;
 
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author - Kunwar Vikas
 */
@RestController
public class SpringBatchJobController {

    @Autowired
    JobLauncher jobLauncher;
 
    @Autowired
    Job stockpricesinfojob;

    /**
     * Invoke the batch job on-demand using rest APIs.
     * @return
     * @throws Exception
     */
    @GetMapping("/invokejob")
    public String invokeBatchJob() throws Exception {
             JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
                    .toJobParameters();
            jobLauncher.run(stockpricesinfojob, jobParameters);
         return "Batch job has been invoked";
    }

    /**
     * Schuled batch job every minute to load the stock prices and send notification
     * @return
     * @throws JobParametersInvalidException
     * @throws JobExecutionAlreadyRunningException
     * @throws JobRestartException
     * @throws JobInstanceAlreadyCompleteException
     */
    @Scheduled(fixedRate = 60000)
    public String schedule() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
                .toJobParameters();
        jobLauncher.run(stockpricesinfojob, jobParameters);
        return "Batch job has been invoked";
    }
}