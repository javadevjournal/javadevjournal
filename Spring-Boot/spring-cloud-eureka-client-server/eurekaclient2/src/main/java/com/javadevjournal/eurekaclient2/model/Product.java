package com.javadevjournal.eurekaclient2.model;
import java.util.Objects;
import java.util.UUID;

public class Product {

    private UUID productId;
    private String productName;
    private double productPrice;
    private String productCategory;

    public Product() {
    }

    public Product(UUID productId, String productName, double productPrice, String productCategory) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
    }

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Double.compare(product.getProductPrice(), getProductPrice()) == 0 &&
                Objects.equals(getProductId(), product.getProductId()) &&
                Objects.equals(getProductName(), product.getProductName()) &&
                Objects.equals(getProductCategory(), product.getProductCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductId(), getProductName(), getProductPrice(), getProductCategory());
    }

    @Override
    public String toString() {
        return "Products{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productCategory='" + productCategory + '\'' +
                '}';
    }
}
