package com.javadevjournal.rest.service;

import com.javadevjournal.rest.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    public Page<ProductEntity> findAllProducts(Pageable pageable);
}
