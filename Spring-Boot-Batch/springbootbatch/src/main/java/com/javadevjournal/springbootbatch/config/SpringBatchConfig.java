package com.javadevjournal.springbootbatch.config;

import com.javadevjournal.springbootbatch.listener.SpringBatchJobExecutionListener;
import com.javadevjournal.springbootbatch.listener.SpringBatchStepListener;
import com.javadevjournal.springbootbatch.model.Employee;
import com.javadevjournal.springbootbatch.step.EmployeeItemProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.transform.PassThroughLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.javadevjournal.springbootbatch.listener.SpringBatchJobCompletionListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @Author - Kunwar Vikas
 */
@Configuration
public class SpringBatchConfig {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Bean
	public Job processJob() {
		return jobBuilderFactory.get("stockpricesinfojob")
				.incrementer(new RunIdIncrementer())
				.listener(new SpringBatchJobExecutionListener())
				.flow(StockPricesInfoStep())
                .end()
                .build();
	}

    @Bean
    public Step StockPricesInfoStep() {
        return stepBuilderFactory.get("step1")
                .listener(new SpringBatchStepListener())
                .<Employee, String>chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .faultTolerant()
                .retryLimit(3)
                .retry(Exception.class)
                .build();
    }

    @Bean
    public FlatFileItemReader<Employee> reader() {
        return new FlatFileItemReaderBuilder<Employee>()
                .name("stockInfoItemReader")
                .resource(new ClassPathResource("csv/stockinfo.csv"))
                .delimited()
                .names(new String[] {"stockId", "stockName","stockPrice","yearlyHigh","yearlyLow","address","sector","market"})
                .targetType(Employee.class)
                .build();
    }

    @Bean
    public EmployeeItemProcessor processor() {
        return new EmployeeItemProcessor();
    }

    @Bean
    public FlatFileItemWriter<String> writer() {
        return new FlatFileItemWriterBuilder<String>()
                .name("stockInfoItemWriter")
                .resource(new FileSystemResource(
                        "target/output.txt"))
                .lineAggregator(new PassThroughLineAggregator<>()).build();
    }

	@Bean
	public JobExecutionListener listener() {
		return new SpringBatchJobCompletionListener();
	}
}
