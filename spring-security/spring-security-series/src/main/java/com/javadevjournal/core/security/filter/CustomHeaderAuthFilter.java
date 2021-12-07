package com.javadevjournal.core.security.filter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomHeaderAuthFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        var request = (HttpServletRequest) servletRequest;
        var response = (HttpServletResponse)servletResponse;

        //if header is missing , send un-athorized error back
        String authHeader = request.getHeader("X-HEADER");
        if(StringUtils.isEmpty(authHeader)){
            response.setStatus(
                    HttpServletResponse.SC_UNAUTHORIZED);
        }
        else{
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
