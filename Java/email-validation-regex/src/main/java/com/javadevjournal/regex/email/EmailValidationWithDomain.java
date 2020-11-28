package com.javadevjournal.regex.email;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidationWithDomain implements EmailValidation {

    private static Pattern EMAIL_REGEX= Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,12}$", Pattern.CASE_INSENSITIVE);

    /**
     * This email validation use the regular expression to check the email pattern.
     * It also check the length of the domain name (e.g. .com , .net, .media etc). You can always modify
     * the regular expression to increase the length which checking the domain name character length
     * @param email
     * @return
     */
    @Override
    public boolean validateEmailAddress(String email) {
        final Matcher matcher = EMAIL_REGEX.matcher(email);
        return matcher.matches();
    }
}
