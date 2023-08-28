package com.javadevjournal.designpatterns.composite;

import java.util.ArrayList;
import java.util.List;

// Composite class
class ProductCategory implements ProductComponent {
    private String categoryName;
    private List<ProductComponent> products = new ArrayList<>();

    public ProductCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public void addProduct(ProductComponent product) {
        products.add(product);
    }

    @Override
    public void displayInfo() {
        System.out.println("Category: " + categoryName);
        for (ProductComponent product : products) {
            product.displayInfo();
        }
    }
}