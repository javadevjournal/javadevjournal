package com.javadevjournal.data;

import java.io.Serializable;

public class Customer implements Serializable {

    private String firstName;
    private String lastName;
    private Order order;

    //Copy Constructor
    public Customer(Customer customer) {
        this(customer.getFirstName(),customer.getFirstName(),new Order(customer.getOrder()));
    }

    public Customer(String firstName, String lastName, Order order) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.order = order;
    }

    @Override
    public Customer clone(){
        Customer customer =null;
        try {
            customer = (Customer) super.clone();
        } catch (CloneNotSupportedException e) {
            customer = new Customer(this.firstName,this.lastName,this.order);
        }
        customer.order=this.order.clone();
        return customer;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
