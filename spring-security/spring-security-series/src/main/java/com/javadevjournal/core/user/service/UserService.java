package com.javadevjournal.core.user.service;

import com.javadevjournal.core.exception.InvalidTokenException;
import com.javadevjournal.core.exception.UnkownIdentifierException;
import com.javadevjournal.core.exception.UserAlreadyExistException;
import com.javadevjournal.core.user.jpa.data.UserEntity;
import com.javadevjournal.web.data.user.UserData;

public interface UserService {

    void register(final UserData user) throws UserAlreadyExistException;
    boolean checkIfUserExist(final String email);
    void sendRegistrationConfirmationEmail(final UserEntity user);
    boolean verifyUser(final String token) throws InvalidTokenException;
    UserEntity getUserById(final String id) throws UnkownIdentifierException;
}
