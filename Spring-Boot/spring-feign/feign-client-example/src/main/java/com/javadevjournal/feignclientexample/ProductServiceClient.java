package com.javadevjournal.feignclientexample;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "product-service"/*, url = "http://localhost:8081"*/)
public interface ProductServiceClient {

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> getAllProducts();

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable("id") int productId);

}
