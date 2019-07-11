package com.javadevjournal.data;

import java.time.LocalDate;

public class Order {

    private double totalPrice;
    private String code;
    private LocalDate date;

    public Order(double totalPrice, String code, LocalDate localDate) {
        this.totalPrice = totalPrice;
        this.code = code;
        this.date=localDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getCode() {
        return code;
    }

    public LocalDate getDate() {
        return date;
    }
}
