package com.javadevjournal.user.service;

import com.javadevjournal.system.exception.UserAlreadyExistException;
import com.javadevjournal.user.jpa.data.UserEntity;
import com.javadevjournal.user.jpa.repository.UserRepository;
import com.javadevjournal.web.data.user.UserData;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userService")
public class DefaultUserService implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void register(UserData user) throws UserAlreadyExistException {
        if(checkIfUserExist(user.getEmail())){
            throw new UserAlreadyExistException("User already exists for this email");
        }
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        encodePassword(user, userEntity);
        userRepository.save(userEntity);
    }

    @Override
    public boolean checkIfUserExist(String email) {
        return userRepository.findByEmail(email)!=null ? true : false;
    }

    private void encodePassword(UserData source, UserEntity target){
        target.setPassword(passwordEncoder.encode(source.getPassword()));
    }
}
