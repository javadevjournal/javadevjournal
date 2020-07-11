package com.javadevjournal.springbootbatch.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

/**
 * @Author - Kunwar Vikas
 */
public class SpringBatchStepListener implements StepExecutionListener {

    Logger logger = LoggerFactory.getLogger(SpringBatchStepListener.class);

    @Override
    public void beforeStep(StepExecution stepExecution) {
        logger.info("SPStepListener - CALLED BEFORE STEP.");
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        logger.info("SPStepListener - CALLED AFTER STEP.");
        return ExitStatus.COMPLETED;
    }
}
