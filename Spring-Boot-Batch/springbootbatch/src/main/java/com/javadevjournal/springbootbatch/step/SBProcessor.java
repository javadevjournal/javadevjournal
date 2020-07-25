package com.javadevjournal.springbootbatch.step;

import org.springframework.batch.item.ItemProcessor;

/**
 * @Author - Kunwar Vikas
 */
public class SBProcessor implements ItemProcessor<String, String> {

	@Override
	public String process(String data) throws Exception {
		return data.toUpperCase();
	}

}
