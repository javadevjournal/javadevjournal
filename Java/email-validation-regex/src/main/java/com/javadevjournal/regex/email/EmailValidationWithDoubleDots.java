package com.javadevjournal.regex.email;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidationWithDoubleDots implements EmailValidation {

    private static Pattern EMAIL_REGEX= Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\\\.[a-zA-Z0-9-]+)*$");

    /**
     * Email validation regex to restrict leading, trailing dots. It also will check if the
     * email contains consecutive dots.
     * @param email
     * @return
     */
    @Override
    public boolean validateEmailAddress(String email) {
        final Matcher matcher = EMAIL_REGEX.matcher(email);
        return matcher.matches();
    }
}
