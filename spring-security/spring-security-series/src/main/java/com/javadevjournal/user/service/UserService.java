package com.javadevjournal.user.service;

import com.javadevjournal.system.exception.UserAlreadyExistException;
import com.javadevjournal.web.data.user.UserData;

public interface UserService {

    void register(final UserData user) throws UserAlreadyExistException;
    boolean checkIfUserExist(final String email);
}
