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
public class DefaultUserService implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    /**
     * <p></p>Service method to save the user information in the database.This method will get the user data
     * from the controller and will convert it to JPA entity before saving in the database.</p>
     * <p>This is a simple example else I will recommend to have a populators which convert source to target data.</p>
     * @param user
     */
    @Override
    public void register(UserData user) throws UserAlreadyExistException {

        //Let's check if user already registered with us
        if(checkIfUserExist(user.getEmail())){
            throw new UserAlreadyExistException("User already exists for this email");
        }
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        encodePassword(userEntity, user);
        userRepository.save(userEntity);
    }

    /**
     * <p></p>Method to check if user already exist for a given email id.We will not allow
     * the same email id for multiple registrations and treating email as unique</p>
     * @param email
     * @return
     */
    @Override
    public boolean checkIfUserExist(String email) {
        return userRepository.findByEmail(email) !=null ? true : false;
    }

    private void encodePassword( UserEntity userEntity, UserData user){
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
    }
}
