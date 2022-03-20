package javadevjournal.design.creational.factory.banking;

/**
 * @author Kunwar
 */
public class PersonalAccount implements BankAccount{
    @Override
    public void registerAccount() {
        System.out.println("Creating a personal account");
    }
}
