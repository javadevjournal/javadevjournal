package com.javadevjournal;

import java.net.URI;
import java.util.Base64;

import org.junit.Test;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.context.ServerPortInfoApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;


public class SpringSessionAppApplicationTests {


    private TestRestTemplate testRestTemplate;
    private String testUrl = "http://localhost:8080/";


    @Test
    public void testUnauthenticatedCantAccess() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result = restTemplate.getForEntity(testUrl, String.class);
        assertEquals(HttpStatus.UNAUTHORIZED, result.getStatusCode());
    }

    @Test
    public void testSpringSessionAPI() {

        URI uri = URI.create(testUrl);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> firstResponse = firstRequest(restTemplate, uri);
        String sessionId1 = firstResponse.getBody();
        String cookie = firstResponse.getHeaders().getFirst("Set-Cookie");
        String sessionId2 = nextRequest(restTemplate, uri, cookie).getBody();
        assertThat(sessionId1).isEqualTo(sessionId2);

    }


    private ResponseEntity<String> firstRequest(RestTemplate restTemplate, URI uri) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Basic "
                + Base64.getEncoder().encodeToString("admin:nimda".getBytes()));
        RequestEntity<Object> request = new RequestEntity<>(headers, HttpMethod.GET, uri);
        return restTemplate.exchange(request, String.class);
    }

    private ResponseEntity<String> nextRequest(RestTemplate restTemplate, URI uri,
                                               String cookie) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Cookie", cookie);
        RequestEntity<Object> request = new RequestEntity<>(headers, HttpMethod.GET, uri);
        return restTemplate.exchange(request, String.class);
    }


}
