package com.javadevjournal.eurekaclient2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Eurekaclient2Controller {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    private RestTemplate restTemplate = new RestTemplate();

    @RequestMapping("/calleurekaclient2")
    public ResponseEntity<String> callEurekaClient2(){
        return new ResponseEntity<String>("Hello From Client 2", HttpStatus.OK);
    }

    @RequestMapping("/callEurekaClient3viaClient2")
    public ResponseEntity<String> callClient2(){
        try {
            return new ResponseEntity<String>(
                    restTemplate.getForObject(getEurkaClient2BaseUri() + "/calleurekaclient3", String.class), HttpStatus.OK);
        }catch (Exception exp) {
            return new ResponseEntity<String>(
                    restTemplate.getForObject(getEurkaClient2BaseUri() + "/calleurekaclient3", String.class), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private String getEurkaClient2BaseUri(){
        ServiceInstance serviceInstance =  loadBalancerClient.choose("EUREKACLIENT3");
        return serviceInstance.getUri().toString();
    }
}

