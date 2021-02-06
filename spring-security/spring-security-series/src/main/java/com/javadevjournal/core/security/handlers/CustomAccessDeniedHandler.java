package com.javadevjournal.core.security.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    private static final Logger LOG = LoggerFactory.getLogger(CustomAccessDeniedHandler.class);

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication!=null){

            LOG.info("User '" + authentication.getName()
                    + "' attempted to access the URL: "
                    + request.getRequestURI());
        }
        response.sendRedirect(request.getContextPath()+ "/access-denied");
    }
}
