package com.javadevjournal.core.user.service;

import com.javadevjournal.core.exception.InvalidTokenException;
import com.javadevjournal.core.exception.UnkownIdentifierException;

public interface CustomerAccountService {

    void forgottenPassword(final String userName) throws UnkownIdentifierException;
    void updatePassword(final String password, final String token) throws InvalidTokenException, UnkownIdentifierException;
    boolean loginDisabled(final String username);
}
