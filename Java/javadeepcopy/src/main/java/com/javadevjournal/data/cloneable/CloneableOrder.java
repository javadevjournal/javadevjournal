package com.javadevjournal.data.cloneable;

import java.util.Objects;

public class CloneableOrder implements Cloneable {

    private String orderNumber;
    private double orderAmount;
    private String orderStatus;



    public CloneableOrder(String orderNumber, double orderAmount, String orderStatus) {
        this.orderNumber = orderNumber;
        this.orderAmount = orderAmount;
        this.orderStatus = orderStatus;
    }

    public String getOrderNumber() {

        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {

        this.orderNumber = orderNumber;
    }

    public double getOrderAmount() {

        return orderAmount;
    }

    public void setOrderAmount(double orderAmount) {

        this.orderAmount = orderAmount;
    }

    public String getOrderStatus() {

        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {

        this.orderStatus = orderStatus;
    }

    @Override
    public CloneableOrder clone() throws CloneNotSupportedException{
       return (CloneableOrder) super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CloneableOrder)) return false;
        CloneableOrder that = (CloneableOrder) o;
        return Double.compare(that.getOrderAmount(), getOrderAmount()) == 0 &&
                Objects.equals(getOrderNumber(), that.getOrderNumber()) &&
                Objects.equals(getOrderStatus(), that.getOrderStatus());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getOrderNumber(), getOrderAmount(), getOrderStatus());
    }
}
