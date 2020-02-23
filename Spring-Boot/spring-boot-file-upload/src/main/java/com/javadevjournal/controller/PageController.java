package com.javadevjournal.controller;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class PageController {

    public String fileDownloadUrl(final String fileName, final String baseURL){
        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(baseURL)
                .path(fileName).toUriString();
    }
}
