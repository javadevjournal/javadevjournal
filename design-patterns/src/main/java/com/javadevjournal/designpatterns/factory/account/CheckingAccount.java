package com.javadevjournal.designpatterns.factory.account;

public class CheckingAccount implements BankAccount{
    @Override
    public void registerAccount() {
        System.out.println("Creating a checking account");
    }
}
