package com.javadevjournal.customlogout.core.service;

import com.javadevjournal.customlogout.core.entity.UserEntity;
import com.javadevjournal.customlogout.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	UserRepository userRepository;

	@Override
	public long saveUser(UserEntity userEntity) {
		UserEntity savedEntity = userRepository.save(userEntity);
		return savedEntity.getId();
	}

	@Override
	public UserEntity findUserByUsername(String userName){
		return userRepository.findByEmailOrUserName(userName,userName);
	}
}
