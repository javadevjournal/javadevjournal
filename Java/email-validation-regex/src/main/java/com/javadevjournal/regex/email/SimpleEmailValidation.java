package com.javadevjournal.regex.email;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class contains different utility methods to validate emails
 */
public class SimpleEmailValidation implements EmailValidation{

    private static  Pattern EMAIL_REGEX= Pattern.compile("^(.+)@(.+)$");


    /**
     * A simple validation which check for @ symbol and make sure there is
     * some character before and after the @ symbol
     * @param email
     * @return
     */
    @Override
    public boolean validateEmailAddress(String email) {
        final Matcher matcher = EMAIL_REGEX.matcher(email);
        return matcher.matches();
    }

}
