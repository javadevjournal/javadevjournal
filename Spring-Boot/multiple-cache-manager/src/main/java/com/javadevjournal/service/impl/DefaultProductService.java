package com.javadevjournal.service.impl;

import com.javadevjournal.data.Product;
import com.javadevjournal.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("productService")
public class DefaultProductService implements ProductService {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultProductService.class);

    @Cacheable(cacheNames = "products", cacheManager = "alternateCacheManager")
    @Override
    public Product getProductByCode(String code) {
        LOG.info("Get product by code {} ", code);
        Product product = new Product();
        product.setCode(code);
        product.setBrand("Sony");
        product.setDescription("Sony new camera");
        product.setName("Sony Alpha A7S");
        return product;
    }

    @Cacheable(cacheNames = "products", cacheResolver = "cacheResolver", key ="#brand" )
    @Override
    public Product getProductByBrand(String brand) {
        LOG.info("Get product by brand {} ", brand);
        Product product = new Product();
        product.setCode("321");
        product.setBrand(brand);
        product.setDescription("Sony new camera");
        product.setName("Sony Alpha 7C");
        return product;
    }
}
