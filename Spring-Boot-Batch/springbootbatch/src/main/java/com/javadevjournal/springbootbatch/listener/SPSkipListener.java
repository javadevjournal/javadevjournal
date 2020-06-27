package com.javadevjournal.springbootbatch.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.SkipListener;

/**
 * @Author - Kunwar Vikas
 */
public class SPSkipListener implements SkipListener<String, Number> {

    Logger logger = LoggerFactory.getLogger(SPSkipListener.class);

    @Override
    public void onSkipInRead(Throwable t) {
        logger.info("onSkipInRead");
    }

    @Override
    public void onSkipInWrite(Number item, Throwable t) {
        logger.info("onSkipInWrite");
    }

    @Override
    public void onSkipInProcess(String item, Throwable t) {
        logger.info("onWriteError");
    }
}
