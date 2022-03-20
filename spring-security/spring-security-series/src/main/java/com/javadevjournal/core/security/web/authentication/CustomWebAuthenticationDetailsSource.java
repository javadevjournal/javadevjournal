package com.javadevjournal.core.security.web.authentication;

import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class CustomWebAuthenticationDetailsSource implements AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> {

    @Override
    public CustomWebAuthenticationDetails buildDetails(HttpServletRequest context) {
        return new CustomWebAuthenticationDetails(context);
    }
}
