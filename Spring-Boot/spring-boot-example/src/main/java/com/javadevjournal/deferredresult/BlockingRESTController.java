package com.javadevjournal.deferredresult;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlockingRESTController {

    @GetMapping("/blocking-request")
    public ResponseEntity<?> blockHttpRequest() throws InterruptedException {

        Thread.sleep(40000);
        return  ResponseEntity.ok("OK");
    }
}
