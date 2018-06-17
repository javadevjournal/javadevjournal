package com.javadevjournal.rest.service;

import com.javadevjournal.rest.entity.ProductEntity;
import com.javadevjournal.rest.jpa.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DefaultProductService implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<ProductEntity> findAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }
}
