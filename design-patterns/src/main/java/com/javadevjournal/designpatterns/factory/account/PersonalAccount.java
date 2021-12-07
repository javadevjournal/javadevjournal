package com.javadevjournal.designpatterns.factory.account;

public class PersonalAccount implements BankAccount{
    @Override
    public void registerAccount() {
        System.out.println("Creating a personal account");
    }
}
