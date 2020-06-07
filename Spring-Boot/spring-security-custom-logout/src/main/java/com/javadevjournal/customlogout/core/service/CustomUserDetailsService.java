package com.javadevjournal.customlogout.core.service;
import com.javadevjournal.customlogout.core.entity.UserEntity;
import com.javadevjournal.customlogout.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final UserEntity userEntity = userRepository.findUserByUsername(username);
		if (userEntity == null) {
			throw new UsernameNotFoundException(username);
		}
		UserDetails user = User.withUsername(userEntity.getEmail()).password(userEntity.getPassword()).authorities("USER").build();
		return user;
	}
}
