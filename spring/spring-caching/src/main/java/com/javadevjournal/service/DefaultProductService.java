package com.javadevjournal.service;

import com.javadevjournal.caching.annotation.CustomCachingAnnotation;
import com.javadevjournal.data.Product;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultProductService implements ProductService {

    @Override
    @Cacheable("products")
    public List<Product> getProducts() {

        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            simulateSlowness();
            productList.add(new Product(String.valueOf(i), "Demo Product", "Sample Description"));
        }
        return productList;
    }

    @Override
    @CustomCachingAnnotation
    public Product getProduct(String productCode) {
        simulateSlowness();
        return new Product(productCode,"Demo Product", "Sample Description");
    }

    private void simulateSlowness() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
