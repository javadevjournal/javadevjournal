package com.javadevjournal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.javadevjournal.components")
public class ServletComponentScanAnnotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServletComponentScanAnnotationApplication.class, args);
	}

}
