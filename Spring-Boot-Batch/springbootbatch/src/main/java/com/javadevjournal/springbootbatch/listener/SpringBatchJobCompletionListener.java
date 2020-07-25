package com.javadevjournal.springbootbatch.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

/**
 * @Author - Kunwar Vikas
 */
public class SpringBatchJobCompletionListener extends JobExecutionListenerSupport {
	Logger logger = LoggerFactory.getLogger(SpringBatchJobCompletionListener.class);

	@Override
	public void beforeJob(JobExecution jobExecution) {
		logger.info("SpringBatchJobCompletionListener - BEFORE BATCH JOB STARTS");
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			logger.info("SpringBatchJobCompletionListener - BATCH JOB COMPLETED SUCCESSFULLY");
		}else if(jobExecution.getStatus() == BatchStatus.FAILED){
			logger.info("SpringBatchJobCompletionListener - BATCH JOB FAILED");
		}
	}

}
