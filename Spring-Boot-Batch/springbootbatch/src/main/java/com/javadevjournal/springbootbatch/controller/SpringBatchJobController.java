package com.javadevjournal.springbootbatch.controller;
 
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author - Kunwar Vikas
 */
@RestController
public class SpringBatchJobController {

    @Autowired
    JobLauncher jobLauncher;
 
    @Autowired
    Job javadevjournaljob;
 
    @GetMapping("/invokejob")
    public String invokeBatchJob() throws Exception {
             JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
                    .toJobParameters();
            jobLauncher.run(javadevjournaljob, jobParameters);
         return "Batch job has been invoked";
    }
}