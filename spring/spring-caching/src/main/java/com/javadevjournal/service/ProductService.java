package com.javadevjournal.service;

import com.javadevjournal.data.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();
    Product getProduct(String productCode);
}
