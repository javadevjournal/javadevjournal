package com.javadevjournal.springbootbatch.listener;

import com.javadevjournal.springbootbatch.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * @Author - Kunwar Vikas
 */
public class SPItemWriteListener implements ItemWriteListener<Number> {
    Logger logger = LoggerFactory.getLogger(SPItemWriteListener.class);

    public void beforeWrite(List items) {
        logger.info("before write");
    }

    public void onWriteError(Exception exception, List items) {
        logger.info("Error occurred when writing items!");
    }
    public void afterWrite(List items) {
        logger.info("after write");
    }
}
