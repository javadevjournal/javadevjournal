package com.javadevjournal.springbootbatch.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * @Author - Kunwar Vikas
 */
public class SpringBatchJobExecutionListener implements JobExecutionListener {

    Logger logger = LoggerFactory.getLogger(SpringBatchJobExecutionListener.class);

    public void beforeJob(JobExecution jobExecution) {
        logger.info("BEFORE BATCH JOB STARTS");
    }

    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            logger.info("BATCH JOB COMPLETED SUCCESSFULLY");
        }else if(jobExecution.getStatus() == BatchStatus.FAILED){
            logger.info("BATCH JOB FAILED");
        }
    }
}
