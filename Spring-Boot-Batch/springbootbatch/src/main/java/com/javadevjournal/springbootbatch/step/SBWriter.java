package com.javadevjournal.springbootbatch.step;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

public class SBWriter implements ItemWriter<String> {
	Logger logger = LoggerFactory.getLogger(SBWriter.class);
	@Override
	public void write(List<? extends String> messages) throws Exception {
		for (String msg : messages) {
			logger.info("Writing the data \n" + msg);
		}
	}

}