package com.javadevjournal.designpatterns.composite;

public class CompositePatternExample {

    public static void main(String[] args) {
        // Create individual products
        Product product1 = new Product("Product A", 10.0);
        Product product2 = new Product("Product B", 20.0);

        // Create a product category and add products to it
        ProductCategory category1 = new ProductCategory("Category 1");
        category1.addProduct(product1);
        category1.addProduct(product2);

        // Create another individual product
        Product product3 = new Product("Product C", 15.0);

        // Create another product category and add products to it
        ProductCategory category2 = new ProductCategory("Category 2");
        category2.addProduct(product3);
        category2.addProduct(category1); // Adding a category to a category

        // Display information using the composite structure
        System.out.println("Displaying products:");
        category2.displayInfo();
    }
}
