package com.javadevjournal.services;

import com.javadevjournal.data.Product;
import com.javadevjournal.data.ProductReviews;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    public List<ProductReviews> getProductReviews(final String productCode){

        List<ProductReviews> productReviews = new ArrayList<>();
        for(int i=1; i< 3; i++){
            ProductReviews reviews = new ProductReviews();
            reviews.setCode(String.valueOf(i));
            reviews.setProductCode(productCode);
            reviews.setScore(i);
            productReviews.add(reviews);
        }

        return  productReviews;
    }

    public List<Product> getProducts(){

        List<Product> products = new ArrayList<>();
        for(int i=1; i< 3; i++){

            Product product = new Product();
            product.setCode(String.valueOf(i));
            product.setName("Product"+i);
            product.setDescription("This is a demo product number :"+i);
            product.setCategoryId("cat_"+i);
            product.setPrice(i*12.67);
            products.add(product);
        }
        return products;
    }

    public Product getProductById(final String code){

        Product product = new Product();
        product.setCode(code);
        product.setName("Sample Product");
        product.setDescription("This is our first sample product");
        product.setPrice(100.00);
        product.setCategoryId("Cat1");
        return product;
    }
}
