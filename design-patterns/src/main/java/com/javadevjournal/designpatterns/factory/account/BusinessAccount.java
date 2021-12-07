package com.javadevjournal.designpatterns.factory.account;

public class BusinessAccount implements BankAccount {
    @Override
    public void registerAccount() {
        System.out.println("Creating a business account");
    }
}