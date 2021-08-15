package com.javadevjournal.core.security.core.userdetail;

import com.javadevjournal.core.user.jpa.data.Group;
import com.javadevjournal.core.user.jpa.data.UserEntity;
import com.javadevjournal.core.user.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Service("userDetailsService")
@Transactional
public class CustomUserDetailService implements UserDetailsService{


    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        final UserEntity customer = userRepository.findByEmail(email);
        if (customer == null) {
            throw new UsernameNotFoundException(email);
        }
        boolean enabled = !customer.isAccountVerified(); // we can use this in case we want to activate account after customer verified the account
        UserDetails user = User.withUsername(customer.getEmail())
                .password(customer.getPassword())
                .disabled(customer.isLoginDisabled())
                .authorities(getAuthorities(customer)).build()
                ;

        return user;
    }

    private Collection<GrantedAuthority> getAuthorities(UserEntity user){
        Set<Group> userGroups = user.getUserGroups();
        Collection<GrantedAuthority> authorities = new ArrayList<>(userGroups.size());
        for(Group userGroup : userGroups){
            authorities.add(new SimpleGrantedAuthority(userGroup.getCode().toUpperCase()));
        }

        return authorities;
    }
}
