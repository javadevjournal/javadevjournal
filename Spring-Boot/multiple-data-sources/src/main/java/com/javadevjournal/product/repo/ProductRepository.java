package com.javadevjournal.product.repo;

import com.javadevjournal.product.data.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel,Integer> {
}
