package com.javadevjournal.customlogout.core.service;

import com.javadevjournal.customlogout.core.entity.UserEntity;

public interface UserService {
	long saveUser(UserEntity userEntity);

	UserEntity findUserByUsername(String userName);
}
