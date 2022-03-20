package com.javadevjournal.core.security.authentication;


import com.javadevjournal.core.security.core.userdetail.CustomUser;
import com.javadevjournal.core.security.mfa.MFATokenManager;
import com.javadevjournal.core.security.web.authentication.CustomWebAuthenticationDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class CustomAuthenticationProvider extends DaoAuthenticationProvider {

    @Resource
    private MFATokenManager mfaTokenManager;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Autowired
    public CustomAuthenticationProvider(UserDetailsService userDetailsService) {
        super.setUserDetailsService(userDetailsService);
    }

    protected void additionalAuthenticationChecks(UserDetails userDetails,
                                                  UsernamePasswordAuthenticationToken authentication)
            throws AuthenticationException {

        super.additionalAuthenticationChecks(userDetails, authentication);

        //token check
        CustomWebAuthenticationDetails authenticationDetails = (CustomWebAuthenticationDetails) authentication.getDetails();
        CustomUser user = (CustomUser) userDetails;
        String mfaToken = authenticationDetails.getToken();
        if(!mfaTokenManager.verifyTotp(mfaToken,user.getSecret())){
            throw new BadCredentialsException(messages.getMessage(
                    "AbstractUserDetailsAuthenticationProvider.badCredentials",
                    "Bad credentials"));
        }
    }


}
