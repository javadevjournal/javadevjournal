package com.javadevjournal.config;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * EnableGlobalMethodSecurity to allow method level Spring security annotation for our application
 */

@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
)
public class MethodSecurityConfig {
    //default configuration class
}
