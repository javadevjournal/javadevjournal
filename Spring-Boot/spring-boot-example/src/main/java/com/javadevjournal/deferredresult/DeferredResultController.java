package com.javadevjournal.deferredresult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.ForkJoinPool;

@RestController
public class DeferredResultController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeferredResultController.class);

    @GetMapping("/asynchronous-request")
    public DeferredResult<ResponseEntity<?>> asynchronousRequestProcessing(final Model model){

        LOGGER.info("Started processing asynchronous request");
        final DeferredResult<ResponseEntity<?>> deferredResult = new DeferredResult<>();

        /**
         * Section to simulate slow running thread blocking process
         */
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.submit(() -> {
            LOGGER.info("Processing request in new thread");
                try {
                    Thread.sleep(4000);

                } catch (InterruptedException e) {
                    LOGGER.error("InterruptedException while executing the thread {}" , e.fillInStackTrace());
                }
                deferredResult.setResult(ResponseEntity.ok("OK"));
            });

        LOGGER.info("HTTP Wroker thread is relased.");
        deferredResult.onCompletion(() -> LOGGER.info("Processing complete"));
        return deferredResult;
    }

    @GetMapping("/timeout-request")
    public DeferredResult<ResponseEntity<?>> onTimeoutExample(final Model model){

        LOGGER.info("Started processing asynchronous request");
        final DeferredResult<ResponseEntity<?>> deferredResult = new DeferredResult<ResponseEntity<?>>(5000l);
        deferredResult.onTimeout(() ->
                deferredResult.setErrorResult(
                        ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT)
                                .body("Request timeout.")));
        /**
         * Section to simulate slow running thread blocking process
         */
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.submit(() -> {
            LOGGER.info("Processing request in new thread");
            try {
                Thread.sleep(6000);

            } catch (InterruptedException e) {
                LOGGER.error("InterruptedException while executing the thread {}" , e.fillInStackTrace());
            }
            deferredResult.setResult(ResponseEntity.ok("OK"));
        });

        LOGGER.info("HTTP Wroker thread is relased.");
        return deferredResult;
    }


}
