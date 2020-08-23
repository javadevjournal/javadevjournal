package com.javadevjournal.core.email.service;

import com.javadevjournal.core.email.context.AbstractEmailContext;

import javax.mail.MessagingException;

public interface EmailService {

    void sendMail(final AbstractEmailContext email) throws MessagingException;
}
