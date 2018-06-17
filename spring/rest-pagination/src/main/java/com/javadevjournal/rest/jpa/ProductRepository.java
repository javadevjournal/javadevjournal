package com.javadevjournal.rest.jpa;

import com.javadevjournal.rest.entity.ProductEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<ProductEntity,Integer> {
}
