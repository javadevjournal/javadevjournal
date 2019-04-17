package com.javadevjournal.service;

import com.javadevjournal.jpa.Customer;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public interface CustomerService {

    String login(String username, String password);
    Optional<User> findByToken(String token);
    Customer findById(Long id);
}
