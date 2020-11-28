package com.javadevjournal.regex.email;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RFC5322EmailValidation implements EmailValidation {

    private static Pattern EMAIL_REGEX= Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", Pattern.CASE_INSENSITIVE);

    /**
     * Java regular expression to validate email using the RFC 5322. Keep in mind that it also allows
     * few characters which can pause security risks (e.g. | character)
     * @param email
     * @return boolean
     */
    @Override
    public boolean validateEmailAddress(String email) {
        final Matcher matcher = EMAIL_REGEX.matcher(email);
        return matcher.matches();
    }
}
