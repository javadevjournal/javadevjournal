package com.javadevjournal.designpatterns.factory;

import com.javadevjournal.designpatterns.factory.account.BankAccount;
import com.javadevjournal.designpatterns.factory.account.BusinessAccount;
import com.javadevjournal.designpatterns.factory.account.CheckingAccount;
import com.javadevjournal.designpatterns.factory.account.PersonalAccount;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;



public class FactoryDesignPatternTest {


    private BankAccountFactory factory;

    @Before
    public void setUp() {
        factory = new BankAccountFactory();
    }

    @Test
    public void testPersonalAccount(){
        BankAccount account = factory.createAccount("P");
        assertThat(account, instanceOf(PersonalAccount.class));
    }

    @Test
    public void testBusinessAccount(){
        BankAccount account = factory.createAccount("B");
        assertThat(account, instanceOf(BusinessAccount.class));
    }

    @Test
    public void testCheckingAccount(){
        BankAccount account = factory.createAccount("C");
        assertThat(account, instanceOf(CheckingAccount.class));
    }

    @Test
    public void testValidAccountType(){
        BankAccount account = factory.createAccount("X");
        assertNull(account);
    }
}
