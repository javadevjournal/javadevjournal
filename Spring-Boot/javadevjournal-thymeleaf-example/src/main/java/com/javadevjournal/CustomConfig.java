package com.javadevjournal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Configuration
public class CustomConfig implements WebMvcConfigurer {

    @Bean
    public ClassLoaderTemplateResolver yourTemplateResolver() {
        ClassLoaderTemplateResolver configurer = new ClassLoaderTemplateResolver();
        configurer.setPrefix("customLocation/");
        configurer.setSuffix(".html");
        configurer.setTemplateMode(TemplateMode.HTML);
        configurer.setCharacterEncoding("UTF-8");
        configurer.setOrder(0);  // this is important. This way spring //boot will listen to both places 0 and 1
        configurer.setCheckExistence(true);
        return configurer;
    }
}
