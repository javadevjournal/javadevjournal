package javadevjournal.design.creational.factory.banking;

import java.util.Scanner;

/**
 * @author Kunwar
 */
public class Branch {
    public static void main(String[] args) {
        BankAccount bankAccount = null;
        BankAccountFactory bankAccountFactory = new BankAccountFactory();
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter\n" +
                " P for Personal account\n" +
                " B for Business account\n" +
                " C for Checking account\n" +
                "----------------------------");
        String accountType = in.nextLine();
        bankAccount = bankAccountFactory.createAccount(accountType);
        bankAccount.registerAccount();;
    }
}