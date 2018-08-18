package com.javadevjournal.model;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ShoppingCart {

    private String customerName;
    private List<String> products;
    private String product;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }


    public void setProduct(String product) {
        if(CollectionUtils.isEmpty(this.getProducts())){
            List<String> products = new ArrayList<>();
            products.add(product);
            this.setProducts(products);
        }
        else {
            this.getProducts().add(product);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShoppingCart)) return false;
        ShoppingCart that = (ShoppingCart) o;
        return Objects.equals(getCustomerName(), that.getCustomerName()) &&
                Objects.equals(getProducts(), that.getProducts());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getCustomerName(), getProducts());
    }
}
