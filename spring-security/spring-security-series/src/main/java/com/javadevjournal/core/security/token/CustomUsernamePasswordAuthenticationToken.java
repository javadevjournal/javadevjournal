package com.javadevjournal.core.security.token;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class CustomUsernamePasswordAuthenticationToken extends UsernamePasswordAuthenticationToken {

    private String customToken;

    public CustomUsernamePasswordAuthenticationToken(Object principal, Object credentials, String customToken) {
        super(principal, credentials);
        this.customToken = customToken;
    }




}
