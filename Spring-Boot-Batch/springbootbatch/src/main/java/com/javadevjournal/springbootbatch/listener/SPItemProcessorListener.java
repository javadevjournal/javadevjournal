package com.javadevjournal.springbootbatch.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemProcessListener;


/**
 * @Author - Kunwar Vikas
 */
public class SPItemProcessorListener implements ItemProcessListener<String, Number> {

    Logger logger = LoggerFactory.getLogger(SPItemProcessorListener.class);

    @Override
    public void beforeProcess(String item) {
        logger.info("beforeProcess");
    }

    @Override
    public void afterProcess(String item, Number result) {
        logger.info("afterProcess");
    }

    @Override
    public void onProcessError(String item, Exception e) {
        logger.info(" onProcessError");
    }
}
