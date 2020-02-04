package com.javadevjournal.data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class Customer {

    @NotNull(message = "Id can not be null")
    private long id;

    @NotNull(message = "Please provide first Name")
    private String firstName;

    @NotNull(message = "Please provide last Name")
    private String lastName;

    @Email(message = "please provide a valid email id")
    private String email;

    public Customer() {
    }

    public Customer(long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
