package com.javadevjournal.regex.email;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimpleEmailValidationNonLatinTest {

    @ParameterizedTest
    @MethodSource("validEmailList")
    void validate_email(String email){

        SimpleEmailValidation validation = new SimpleEmailValidation();
       // assertTrue(validation.validateNonLatinEamil(email));
    }

    @ParameterizedTest
    @MethodSource("invalidEmailList")
    void invalid_emails(String email){

        SimpleEmailValidation validation = new SimpleEmailValidation();
       // assertTrue(validation.validateNonLatinEamil(email));
    }

    static List<String> validEmailList(){
        return Arrays.asList(
                "contact@javadevjournal.com",
                "contact.us@javadevjournal.com",
                "contact-us+1@javadevjournal.com",
                "test@tüller.com"
        );
    }

    static List<String> invalidEmailList(){
        return Arrays.asList(
                "contact.us#javadevjournal.com",
                "@javadevjournal.com",
                "test@test.corporate",
                "test@tüller.com"
        );
    }
}
