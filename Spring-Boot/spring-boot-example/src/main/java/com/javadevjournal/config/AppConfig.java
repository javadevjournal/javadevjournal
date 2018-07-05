package com.javadevjournal.config;

import com.javadevjournal.filters.CustomURLFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public FilterRegistrationBean<CustomURLFilter> filterRegistrationBean() {
        FilterRegistrationBean<CustomURLFilter> registrationBean = new FilterRegistrationBean();
        CustomURLFilter customURLFilter = new CustomURLFilter();

        registrationBean.setFilter(customURLFilter);
        registrationBean.addUrlPatterns("/greeting/*");
        registrationBean.setOrder(2);  //set precedence
        return registrationBean;
    }
}
