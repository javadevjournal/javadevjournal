package com.javadevjournal.core.email.context;

import com.javadevjournal.core.user.jpa.data.UserEntity;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

public class AccountVerificationEmailContext extends AbstractEmailContext {

    private String token;


    @Override
    public <T> void init(T context){
        //we can do any common configuration setup here
        // like setting up some base URL and context
        UserEntity customer = (UserEntity) context; // we pass the customer informati
        put("firstName", customer.getFirstName());
        setTemplateLocation("emails/email-verification");
        setSubject("Complete your registration");
        setFrom("no-reply@javadevjournal.com");
        setTo(customer.getEmail());
    }

    public void setToken(String token) {
        this.token = token;
        put("token", token);
    }

    public void buildVerificationUrl(final String baseURL, final String token){
        final String url= UriComponentsBuilder.fromHttpUrl(baseURL)
                .path("/register/verify").queryParam("token", token).toUriString();
        put("verificationURL", url);
    }
}
