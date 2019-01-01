package com.javadevjournal;

import com.javadevjournal.data.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping("/product")
    public Product getProduct(){
        return new Product("123","Demo Product",123);
    }
}
