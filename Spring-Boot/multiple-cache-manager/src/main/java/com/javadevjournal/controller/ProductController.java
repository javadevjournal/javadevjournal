package com.javadevjournal.controller;

import com.javadevjournal.data.Product;
import com.javadevjournal.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CacheManager cacheManager;

    @Autowired
    CacheManager alternateCacheManager;

    @GetMapping("/product/{code}")
    public Product getProductByCode(@PathVariable(value = "code") String code){
        Product product = productService.getProductByCode(code);
        alternateCacheManager.getCacheNames();
        return product;
    }

    @GetMapping("/product/brands/{brand}")
    public Product getProductByBrand(@PathVariable(value = "brand") String brand){
        Product product = productService.getProductByBrand(brand);
        cacheManager.getCacheNames();
        return product;
    }
}
