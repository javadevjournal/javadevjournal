package com.javadevjournal.core.security.core.userdetail;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

import java.util.*;
import java.util.function.Function;

public class CustomUser implements UserDetails {

    private String password;
    private  String username;
    private Collection<GrantedAuthority> authorities;
    private  boolean accountNonExpired;
    private  boolean accountNonLocked;
    private  boolean credentialsNonExpired;
    private  boolean enabled;
    private  String secret;

    public CustomUser(String username, String password,
                Collection<? extends GrantedAuthority> authorities, String secret) {
        this(username, password, true, true, true, true, authorities, secret);
    }

    public CustomUser(String username, String password, boolean enabled,
                boolean accountNonExpired, boolean credentialsNonExpired,
                boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, final String secret) {

        if (((username == null) || "".equals(username)) || (password == null)) {
            throw new IllegalArgumentException(
                    "Cannot pass null or empty values to constructor");
        }

        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.accountNonExpired = accountNonExpired;
        this.credentialsNonExpired = credentialsNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.authorities = null;
        this.secret= secret;
    }


    public Collection<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void eraseCredentials() {
        password = null;
    }

    public String getSecret() {
        return secret;
    }

    @Override
    public boolean equals(Object rhs) {
        if (rhs instanceof CustomUser) {
            return username.equals(((CustomUser) rhs).username);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }


    public static final class CustomUserBuilder {
        private String password;
        private String username;
        private Collection<GrantedAuthority> authorities;
        private boolean accountNonExpired;
        private boolean accountNonLocked;
        private boolean credentialsNonExpired;
        private boolean enabled;
        private String secret;

        private CustomUserBuilder() {
        }

        public static CustomUserBuilder aCustomUser() {
            return new CustomUserBuilder();
        }

        public CustomUserBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public CustomUserBuilder withUsername(String username) {
            this.username = username;
            return this;
        }

        public CustomUserBuilder withAuthorities(Collection<GrantedAuthority> authorities) {
            this.authorities = authorities;
            return this;
        }

        public CustomUserBuilder withAccountNonExpired(boolean accountNonExpired) {
            this.accountNonExpired = accountNonExpired;
            return this;
        }

        public CustomUserBuilder withAccountNonLocked(boolean accountNonLocked) {
            this.accountNonLocked = accountNonLocked;
            return this;
        }

        public CustomUserBuilder withCredentialsNonExpired(boolean credentialsNonExpired) {
            this.credentialsNonExpired = credentialsNonExpired;
            return this;
        }

        public CustomUserBuilder withEnabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public CustomUserBuilder withSecret(String secret) {
            this.secret = secret;
            return this;
        }

        public CustomUser build() {
            CustomUser customUser = new CustomUser(username, password, !enabled, !accountNonExpired, !credentialsNonExpired, !accountNonLocked, authorities, secret);
            customUser.authorities = this.authorities;
            return customUser;
        }
    }
}
