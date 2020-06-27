package com.javadevjournal.eurekaclient2.controller;

import com.javadevjournal.eurekaclient2.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class Eurekaclient2Controller {
    private static List<Product> productList = new ArrayList<>();
    static{
        productList = new ArrayList<>();
        Product p1 = new Product(UUID.randomUUID(), "Guitar" , 99.99, "Music");
        Product p2 = new Product(UUID.randomUUID(), "AWS Book" , 29.99, "Books");
        Product p3 = new Product(UUID.randomUUID(), "Bread" , 9.99, "Food");
        Product p4 = new Product(UUID.randomUUID(), "Soap" , 99.99, "Body");
        productList.add(p1);
        productList.add(p2);
        productList.add(p3);
        productList.add(p4);
    }

    @GetMapping("/calleurekaclient2")
    public ResponseEntity<String> callEurekaClient2(){
        return new ResponseEntity<String>("Hello From Client 2", HttpStatus.OK);
    }

    @GetMapping(value = "/allproducts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> list() {
        return Eurekaclient2Controller.productList;
    }

    @GetMapping(value = "/product/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public Product showProduct(@PathVariable UUID id) {
        return new Product(id, "Guitar" , 99.99, "Music");
    }

    @PostMapping(value = "/product/update")
    public String saveProduct(@RequestBody Product product) {
        return "Product with product id: "+ product.getProductId() +" and product name:"+product.getProductName()+" has been saved successfully!";
    }

    @DeleteMapping(value = "/product/delete/{id}")
    public void delete(@PathVariable UUID id) {
        //log "Product "+ id +" has been deleted successfully!";
    }
}

