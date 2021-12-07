package com.javadevjournal.core.security.core.userdetail;

import com.javadevjournal.core.user.jpa.data.Group;
import com.javadevjournal.core.user.jpa.data.UserEntity;
import com.javadevjournal.core.user.jpa.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Service("userDetailsService")
@Transactional
public class CustomUserDetailService implements UserDetailsService{

    @Resource
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        //Let's split the email to get both values
        String[] usernameAndCustomToken = StringUtils.split(email, String.valueOf(Character.LINE_SEPARATOR));

        //if the String arrays is empty or size is not equal to 2, let's throw exception
        if(Objects.isNull(usernameAndCustomToken) || usernameAndCustomToken.length !=2){
            throw new UsernameNotFoundException("User not found");
        }
        final String userName = usernameAndCustomToken[0];
        final String customToken = usernameAndCustomToken[1]; // use it based on your requirement
        final UserEntity customer = userRepository.findByEmail(userName);
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
