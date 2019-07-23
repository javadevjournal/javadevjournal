package com.javadevjournal.controller;

import com.javadevjournal.data.Product;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Api(value = "ProductController" , tags = {"Product Controller"})
@SwaggerDefinition(tags = {
        @Tag(name = "Product Controller", description = "Write description here")
})
@RestController("/v2")
public class ProductController {

    List<Product> products = Arrays.asList(
        new Product("1","G Tech", "G Tech Hard drive", 230.45, 25),
        new Product("2","WD SSD", "WD HDD", 150, 15),
        new Product("3","Samsung SSD", "Samsung Solid State Drive", 100, 12),
        new Product("5","Sandisk Pen Drive", "Sandisk Pen Drive", 12, 200)
    );


    @GetMapping("/products/{code}")
    public Product getProduct(@PathVariable("code") String code){
        return products.stream()
                .filter(p->p.getCode().equalsIgnoreCase(code))
                .collect(Collectors.toList()).get(0); // we know this can throw NPE but let's keep our example simple
    }

    @ApiOperation(value = "List of all products", response = ArrayList.class, tags = "getProducts")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code =404, message = "404 error")
    })
    @GetMapping("/products")
    public List<Product> getProducts(){
        return products;
    }
}
