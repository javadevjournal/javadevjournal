package com.javadevjournal.regex.email;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimpleEmailValidationWithDomainTest {

    @ParameterizedTest(name = "#{index} - Test with email = {0}")
    @MethodSource("validEmailList")
    void validate_email_test(String email){

        EmailValidation validation = new EmailValidationWithDomain();
        assertTrue(validation.validateEmailAddress(email));
    }

    @ParameterizedTest(name = "#{index} - Test with email = {0}")
    @MethodSource("invalidEmailList")
    void invalid_emails_test(String email){

        EmailValidation validation = new EmailValidationWithDomain();
        assertFalse(validation.validateEmailAddress(email));
    }

    static List<String> validEmailList(){
        return Arrays.asList(
                "contact@javadevjournal.com",
                "contact.us@javadevjournal.com",
                "contact-us+1@javadevjournal.com",
                "test@javadevjournal.media.org",
                "test@test.corporations"
        );
    }

    static List<String> invalidEmailList(){
        return Arrays.asList(
                "contact.us#javadevjournal.com",
                "@javadevjournal.com"
        );
    }
}
