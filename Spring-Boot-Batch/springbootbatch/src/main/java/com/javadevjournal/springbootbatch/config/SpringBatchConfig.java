package com.javadevjournal.springbootbatch.config;

import com.javadevjournal.springbootbatch.listener.SPJobExecutionListener;
import com.javadevjournal.springbootbatch.listener.SPStepListener;
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
import com.javadevjournal.springbootbatch.step.SBProcessor;
import com.javadevjournal.springbootbatch.step.SBReader;
import com.javadevjournal.springbootbatch.step.SBWriter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

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
		return jobBuilderFactory.get("javadevjournaljob")
				.incrementer(new RunIdIncrementer())
				.listener(new SPJobExecutionListener())
				.flow(orderStep1()).end().build();
	}


    @Bean
    public Step orderStep1() {
        return stepBuilderFactory.get("step1")
                .listener(new SPStepListener())
                .<Employee, String>chunk(10).reader(reader())
                .processor(processor()).writer(writer()).build();
    }

    @Bean
    public FlatFileItemReader<Employee> reader() {
        return new FlatFileItemReaderBuilder<Employee>()
                .name("employeeItemReader")
                .resource(new ClassPathResource("csv/employees.csv"))
                .delimited().names(new String[] {"firstName", "lastName","department"})
                .targetType(Employee.class).build();
    }

    @Bean
    public EmployeeItemProcessor processor() {
        return new EmployeeItemProcessor();
    }

    @Bean
    public FlatFileItemWriter<String> writer() {
        return new FlatFileItemWriterBuilder<String>()
                .name("greetingItemWriter")
                .resource(new FileSystemResource(
                        "target/output.txt"))
                .lineAggregator(new PassThroughLineAggregator<>()).build();
    }

	@Bean
	public JobExecutionListener listener() {
		return new SpringBatchJobCompletionListener();
	}
}
