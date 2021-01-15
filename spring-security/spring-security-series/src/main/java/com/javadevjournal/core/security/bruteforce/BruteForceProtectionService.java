package com.javadevjournal.core.security.bruteforce;

public interface BruteForceProtectionService {

    /**
     * Method to register every login failure attempt for a given username.
     * We will be using a simple counter to keep track of the failed attempts.
     * @param username
     */
    void registerLoginFailure(final String username);

    /**
     * Method to reset the counter for successful login.
     * We want to make sure that we are setting the counter as 0
     * on successful login to avoid customer lockout.
     * @param username
     */
    void resetBruteForceCounter(final String username);

    /**
     * check if the user account is under brute force attack, this will check the failed count with
     * threshold value and will return true if the failed count exceeds the threshold value.
     * @param username
     * @return
     */
    boolean isBruteForceAttack(final String username);
}
