package com.javadevjournal.springbootbatch.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemReadListener;

/**
 * @Author - Kunwar Vikas
 */
public class SPItemReadListener implements ItemReadListener<String> {

    Logger logger = LoggerFactory.getLogger(SPItemReadListener.class);

    @Override
    public void beforeRead() {
        logger.info("Before reading an item");
    }

    @Override
    public void afterRead(String item) {
        logger.info("After reading an item: "+ item.toString());
    }

    @Override
    public void onReadError(Exception ex) {
        logger.error("Error occurred while reading an item!");
    }
}
