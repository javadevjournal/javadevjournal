package com.javadevjournal.regex.email;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimpleSimpleEmailValidationTest {

    private static final Logger LOG = LogManager.getLogger(SimpleSimpleEmailValidationTest.class);

    @DisplayName("Validate email using simple regex")
    @ParameterizedTest
    @ValueSource(strings = {"contact-us@javadevjournal.com",
    "contact@javadevjournal.com",
    "contact.us@javadevjournal.com",
    "contact-us+1@javadevjournal.com",
     //invalid emails
     "contact.us#javadevjournal.com",
     "@javadevjournal.com",
     "test@test.corporate"
    })
    void validate_email_simpleRegex(String email){

        SimpleEmailValidation validation = new SimpleEmailValidation();
        assertTrue(validation.validateEmailAddress(email));
    }
}
