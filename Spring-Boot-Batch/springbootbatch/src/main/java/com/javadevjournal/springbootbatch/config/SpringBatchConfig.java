package com.javadevjournal.springbootbatch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.javadevjournal.springbootbatch.listener.SpringBatchJobCompletionListener;
import com.javadevjournal.springbootbatch.step.SBProcessor;
import com.javadevjournal.springbootbatch.step.SBReader;
import com.javadevjournal.springbootbatch.step.SBWriter;

@Configuration
public class SpringBatchConfig {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Bean
	public Job processJob() {
		return jobBuilderFactory.get("javadevjournaljob")
				.incrementer(new RunIdIncrementer()).listener(listener())
				.flow(orderStep1()).end().build();
	}

	@Bean
	public Step orderStep1() {
		return stepBuilderFactory.get("step1").<String, String> chunk(1)
				.reader(new SBReader()).processor(new SBProcessor())
				.writer(new SBWriter()).build();
	}

	@Bean
	public JobExecutionListener listener() {
		return new SpringBatchJobCompletionListener();
	}

}
