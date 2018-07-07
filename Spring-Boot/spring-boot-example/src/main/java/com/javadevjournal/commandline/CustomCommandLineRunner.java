package com.javadevjournal.commandline;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CustomCommandLineRunner implements CommandLineRunner,Ordered {

    private static final Logger LOG= LoggerFactory.getLogger(CustomCommandLineRunner.class);

    @Override
    public void run(String... args) throws Exception {
        LOG.info("Custom command line runner is excuted with command line arguments: {}" , Arrays.toString(args));
    }

    @Override
    public int getOrder() {
        return 2;
    }
}
