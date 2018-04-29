package com.javadevjournal.httpclient;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpHeaders;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

import java.io.IOException;
import java.net.*;
import java.util.concurrent.CompletableFuture;

import static jdk.incubator.http.HttpResponse.BodyHandler.asString;

public class HTTPClient {

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        byte[] requestBody ="This is expected to be sent back as part of response body".getBytes();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://postman-echo.com/post")).POST(HttpRequest.BodyProcessor.fromString("This is expected to be sent back as part of response body"))
                .build();

        HttpResponse<String> response= client.send(request, HttpResponse.BodyHandler.asString());
        System.out.println(response.statusCode());
       if(response.statusCode() == 200){
           System.out.println(response.version());
           //process business logic
       }
    }
}
