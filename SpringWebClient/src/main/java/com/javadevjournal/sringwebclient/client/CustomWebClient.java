package com.javadevjournal.sringwebclient.client;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;


@Configuration
public class CustomWebClient {

    @Bean
    public WebClient getWebClient(WebClient.Builder webClientBuilder){

       return webClientBuilder
               .clientConnector(new ReactorClientHttpConnector(getHttpClient()))
               .baseUrl("https://reqres.in/api")
               .build();
    }

    private HttpClient getHttpClient(){
        return HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10_000)
                .doOnConnected(conn -> conn
                .addHandlerLast(new ReadTimeoutHandler(10))
                .addHandlerLast(new WriteTimeoutHandler(10)));
    }
}
