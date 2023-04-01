import java.util.*;

public class JavaConstructor {
    public class Car {
        private String make;
        private String model;
        private int year;

        public Car(String make, String model, int year) {
            this.make = make;
            this.model = model;
            this.year = year;
        }

        public String getMake() {
            return make;
        }

        public String getModel() {
            return model;
        }

        public int getYear() {
            return year;
        }
    }

    public class BankAccount {
        private String accountNumber;
        private String accountHolder;
        private double balance;

        public BankAccount(String accountNumber, String accountHolder, double balance) {
            this.accountNumber = accountNumber;
            this.accountHolder = accountHolder;
            this.balance = balance;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public String getAccountHolder() {
            return accountHolder;
        }

        public double getBalance() {
            return balance;
        }

        public void deposit(double amount) {
            balance += amount;
            System.out.println(amount + " deposited to account " + accountNumber);
        }

        public void withdraw(double amount) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println(amount + " withdrawn from account " + accountNumber);
            } else {
                System.out.println("Insufficient balance");
            }
        }
    }






}
