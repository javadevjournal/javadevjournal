package com.javadevjournal.designpatterns.composite;

// Leaf class
public class Product implements ProductComponent {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void displayInfo() {
        System.out.println("Product: " + name + ", Price: $" + price);
    }
}
