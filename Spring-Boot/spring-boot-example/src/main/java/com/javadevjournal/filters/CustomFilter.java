package com.javadevjournal.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info("########## Initiating Custom filter ##########");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        LOGGER.info("Logging Request  {} : {}", request.getMethod(), request.getRequestURI());

        //call next filter in the filter chain
        filterChain.doFilter(request, response);

        LOGGER.info("Logging Response :{}", response.getContentType());
    }

    @Override
    public void destroy() {
        // TODO: 7/4/18
    }
}
