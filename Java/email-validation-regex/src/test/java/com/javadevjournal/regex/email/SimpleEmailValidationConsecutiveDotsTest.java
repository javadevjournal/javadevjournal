package com.javadevjournal.regex.email;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimpleEmailValidationConsecutiveDotsTest {

    @ParameterizedTest
    @MethodSource("validEmailList")
    void valid_email_test(String email){

        EmailValidation validation = new EmailValidationWithDoubleDots();
        assertTrue(validation.validateEmailAddress(email));
    }

    @ParameterizedTest
    @MethodSource("invalidEmailList")
    void invalid_emails_test(String email){
        EmailValidation validation = new EmailValidationWithDoubleDots();
        assertFalse(validation.validateEmailAddress(email));
    }

    static List<String> validEmailList(){
        return Arrays.asList(
                "contact@javadevjournal.com",
                "contact.us@javadevjournal.com",
                "contact-us+1@javadevjournal.com"

        );
    }

    static List<String> invalidEmailList(){
        return Arrays.asList(
                ".@javadevjournal.com",
                "test@dummy.com.",
                "contact@javadevjournal..com"
        );
    }
}
