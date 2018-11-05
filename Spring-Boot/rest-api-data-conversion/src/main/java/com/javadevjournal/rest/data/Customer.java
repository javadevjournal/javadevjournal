package com.javadevjournal.rest.data;

import com.javadevjournal.rest.annotation.JsonProperty;


public class Customer {

    @JsonProperty("userId")
    private int id;

    @JsonProperty("customerName")
    private String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
