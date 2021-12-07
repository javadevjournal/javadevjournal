package com.javadevjournal.core.security.filter;

import org.springframework.lang.Nullable;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private static final String customToken = "jdjCustomToken";

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        UsernamePasswordAuthenticationToken authRequest =getAuth(request);

        return super.attemptAuthentication(request, response);
    }


    private UsernamePasswordAuthenticationToken getAuth(final HttpServletRequest request){
        String username = obtainUsername(request);
        String password = obtainPassword(request);
        String customToken = obtainCustomToken(request);

        String usernameDomain = String.format("%s%s%s", username.trim(),
                String.valueOf(Character.LINE_SEPARATOR), customToken);

       return new UsernamePasswordAuthenticationToken(
                usernameDomain, password);
    }

    @Nullable
    protected String obtainCustomToken(HttpServletRequest request) {
        return request.getParameter(customToken);
    }
}
