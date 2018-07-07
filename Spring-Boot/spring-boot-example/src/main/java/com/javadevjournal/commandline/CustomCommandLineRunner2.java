package com.javadevjournal.commandline;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Order(1)
public class CustomCommandLineRunner2 implements CommandLineRunner {

    private static final Logger LOG= LoggerFactory.getLogger(CustomCommandLineRunner2.class);

    @Override
    public void run(String... args) throws Exception {
       LOG.info("Calling second command line runner with arguments {}" , Arrays.toString(args));
    }
}
