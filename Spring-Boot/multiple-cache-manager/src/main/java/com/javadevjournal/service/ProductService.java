package com.javadevjournal.service;

import com.javadevjournal.data.Product;

public interface ProductService {

    Product getProductByCode(final String code);
    Product getProductByBrand(final String brand);
}
