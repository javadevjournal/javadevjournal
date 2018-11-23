package com.javadevjournal.controller;

import com.javadevjournal.data.Product;
import com.javadevjournal.data.ProductReviews;
import com.javadevjournal.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping(produces = {"application/hal+json"})
    public Resources<Product> getProducts() {

        List<Product> products = productService.getProducts();
        for (final Product product : products) {
            Link selfLink = linkTo(methodOn(ProductController.class)
                    .getProduct(product.getCode())).withRel("product");
            Link productReview = linkTo(methodOn(ProductController.class)
                    .getReviewsForProduct(product.getCode())).withRel("review");
            product.add(productReview);
            product.add(selfLink);
        }

        Link link = linkTo(methodOn(ProductController.class)
                .getProducts()).withRel("products");
        return new Resources<Product>(products, link);
    }

    @GetMapping(value = "/{productId}")
    public Product getProduct(@PathVariable final String productId) {

        Product product = productService.getProductById(productId);
        product.add(linkTo(ProductController.class).slash(product.getCode()).withSelfRel());
        product.add(linkTo(methodOn(ProductController.class).getReviewsForProduct(productId)).withRel("reviews"));
        return product;
    }

    @GetMapping(value = "/{productId}/reviews", produces = {"application/hal+json"})
    public Resources<ProductReviews> getReviewsForProduct(@PathVariable final String productId) {

        List<ProductReviews> reviews = productService.getProductReviews(productId);
        for (final ProductReviews review : reviews) {
            Link selfLink = linkTo(methodOn(ProductController.class)
                    .getProduct(productId)).withSelfRel();
            review.add(selfLink);
        }

        Link link = linkTo(methodOn(ProductController.class)
                .getReviewsForProduct(productId)).withRel("reviews");
        return new Resources<ProductReviews>(reviews, link);

    }
}
