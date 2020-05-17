package com.javadevjournal.eurekaclient1.controller;

import com.javadevjournal.eurekaclient1.model.Product;
import com.sun.jersey.core.header.MediaTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RestController
public class Eurekaclient1Controller {
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    private RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/calleurekaclient1")
    public ResponseEntity<String> callEurekaClient1(){
        return new ResponseEntity<String>("Hello From Client 1 ", HttpStatus.OK);
    }

    /**
     * call client via client1
     * @return
     */
    @GetMapping("/callEurekaClient2viaClient1")
    public ResponseEntity<String> callClient2(){
        try {
            return new ResponseEntity<String>(
                    restTemplate.getForObject(getEurkaClient2BaseUri() + "/calleurekaclient2", String.class), HttpStatus.OK);
        }catch (Exception exp) {
            return new ResponseEntity<String>(
                    restTemplate.getForObject(getEurkaClient2BaseUri() + "/calleurekaclient2", String.class), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Get the list of all products
     * @return
     */
    @GetMapping(value = "/getallproducts")
    public ResponseEntity<String> getAllProductsFromClient2(){
        try {
            return new ResponseEntity<String>(
                    restTemplate.getForObject(getEurkaClient2BaseUri() + "/allproducts", String.class), HttpStatus.OK);
        }catch (Exception exp) {
            return new ResponseEntity<String>(
                    restTemplate.getForObject(getEurkaClient2BaseUri() + "/allproducts", String.class), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping(value = "/getproductbyid/{id}")
    public ResponseEntity<String> getProducByIDFromClient2(@PathVariable UUID id){
        try {
            return new ResponseEntity<String>(
                    restTemplate.getForObject(getEurkaClient2BaseUri() + "/product/"+id, String.class), HttpStatus.OK);
        }catch (Exception exp) {
            return new ResponseEntity<String>(
                    restTemplate.getForObject(getEurkaClient2BaseUri() + "/product/"+id, String.class), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteproductbyid/{id}")
    public void deleteProductByIDFromClient2(@PathVariable UUID id){
        try {
            restTemplate.delete(getEurkaClient2BaseUri() + "/product/delete/"+id);
        }catch (Exception exp) {
            //log the error
        }
    }

    /**
     * Update Product
     * @return
     */
    @PostMapping(value = "/updteproduct/")
    public ResponseEntity<Product> updateProductFromClient2(){
        try {
            return new ResponseEntity<Product>(
                    restTemplate.postForObject(getEurkaClient2BaseUri() + "/product/update/",new Product(UUID.randomUUID(), "Soap" , 99.99, "Body"),Product.class ), HttpStatus.OK);
        }catch (Exception exp) {
            return new ResponseEntity<Product>(
                    restTemplate.postForObject(getEurkaClient2BaseUri() + "/product/update/",new Product(UUID.randomUUID(), "Soap" , 99.99, "Body"),Product.class ), HttpStatus.OK);
        }
    }

    /**
     * This method will return the instance of client 2 from Eureka Server
     * @return
     */
    private String getEurkaClient2BaseUri(){
        ServiceInstance serviceInstance =  loadBalancerClient.choose("EUREKACLIENT2");
        return serviceInstance.getUri().toString();
    }
}


