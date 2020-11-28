package com.javadevjournal.regex.email;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class W3CHTML5EmailValidationTest {

    @ParameterizedTest(name = "#{index} - Run test with email = {0}")
    @MethodSource("validEmailList")
    void valid_email_test(String email){

        EmailValidation validation = new W3CHTML5EmailValidation();
        assertTrue(validation.validateEmailAddress(email));
    }

    @ParameterizedTest(name = "#{index} - Run test with email = {0}")
    @MethodSource("invalidEmailList")
    void invalid_emails_test(String email){
        EmailValidation validation = new W3CHTML5EmailValidation();
        assertFalse(validation.validateEmailAddress(email));
    }

    static List<String> validEmailList(){
        return Arrays.asList(
                "contact@javadevjournal.com",
                "contact.us@javadevjournal.com",
                "contact-us+1@javadevjournal.com",
                "contact?us+1@javadevjournal.com"
        );
    }

    static List<String> invalidEmailList(){
        return Arrays.asList(
                "@javadevjournal.com",
                "@javadevjournal..com",
                "test@dummy.com",
                "test@test.corporations",
                 "test@126.1.1.1"
        );
    }
}
