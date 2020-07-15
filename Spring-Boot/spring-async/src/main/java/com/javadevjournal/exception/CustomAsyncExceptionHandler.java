package com.javadevjournal.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;

public class CustomAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(CustomAsyncExceptionHandler.class);
    @Override
    public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
        LOG.error("Exception while executing with message {} ", throwable.getMessage());
        LOG.error("Exception happen in {} method ", method.getName());
    }
}
