package com.javadevjournal.regex.email;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class W3CHTML5EmailValidation implements EmailValidation {

    private static Pattern EMAIL_REGEX= Pattern.compile("^[a-zA-Z0-9.!#$%&'*+\\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$");

    @Override
    public boolean validateEmailAddress(String email) {
        final Matcher matcher = EMAIL_REGEX.matcher(email);
        return matcher.matches();
    }
}
