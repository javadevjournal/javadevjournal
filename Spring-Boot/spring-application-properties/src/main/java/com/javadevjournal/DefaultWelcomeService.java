package com.javadevjournal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DefaultWelcomeService {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultWelcomeService.class);
    private String secretKey;

    @Value("${javadevjournal.welcome.message: Welcome!!!}")
    private String welcomeMsg;

    @Value("#{'${javadevjournal.init.keys.new.delimiter}'.split(';')}")
    private List<Integer> newKeys;

    /*public void DefaultWelcomeService(@Value("${javadevjournal.init.secret.key}") String secretKey, @Value("${javadevjournal.max.login.retry}") int retry, @Value("${javadevjournal.enable.guest.checkout}") boolean enableGuestCheckout){
        this.secretKey = secretKey;
        LOG.info("@Value annotation is working for our secret key {}",secretKey);
    }
 */

    public String getGreetingMessage(){
        LOG.info("Welcome newKeys {} ", newKeys);
        return welcomeMsg;
    }
}
