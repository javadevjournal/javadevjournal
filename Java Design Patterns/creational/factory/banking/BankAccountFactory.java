package javadevjournal.design.creational.factory.banking;

/**
 * @author Kunwar
 */
public class BankAccountFactory {
    public BankAccount createAccount(String type){
        BankAccount bankAccount = null;
        if (type.equals("P")){
            bankAccount = new PersonalAccount();
        } else if (type.equals("B")){
            bankAccount = new BusinessAccount();
        } else if (type.equals("C")){
            bankAccount = new CheckingAccount();
        } else {
            System.out.println("Invalid type");
        }
        return bankAccount;
    }
}