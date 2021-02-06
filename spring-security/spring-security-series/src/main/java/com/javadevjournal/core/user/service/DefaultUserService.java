package com.javadevjournal.core.user.service;

import com.javadevjournal.core.email.context.AccountVerificationEmailContext;
import com.javadevjournal.core.email.service.EmailService;
import com.javadevjournal.core.exception.InvalidTokenException;
import com.javadevjournal.core.exception.UnkownIdentifierException;
import com.javadevjournal.core.exception.UserAlreadyExistException;
import com.javadevjournal.core.security.jpa.SecureToken;
import com.javadevjournal.core.security.token.SecureTokenService;
import com.javadevjournal.core.security.token.repository.SecureTokenRepository;
import com.javadevjournal.core.user.jpa.data.Group;
import com.javadevjournal.core.user.jpa.data.UserEntity;
import com.javadevjournal.core.user.jpa.repository.UserGroupRepository;
import com.javadevjournal.core.user.jpa.repository.UserRepository;
import com.javadevjournal.web.data.user.UserData;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.Objects;

@Service("userService")
public class DefaultUserService implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailService emailService;

    @Autowired
    private SecureTokenService secureTokenService;

    @Autowired
    SecureTokenRepository secureTokenRepository;

    @Autowired
    UserGroupRepository groupRepository;

    @Value("${site.base.url.https}")
    private String baseURL;

    @Override
    public void register(UserData user) throws UserAlreadyExistException {
        if(checkIfUserExist(user.getEmail())){
            throw new UserAlreadyExistException("User already exists for this email");
        }
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        encodePassword(user, userEntity);
        updateCustomerGroup(userEntity);
        userRepository.save(userEntity);
        sendRegistrationConfirmationEmail(userEntity);

    }

    private void updateCustomerGroup(UserEntity userEntity){
        Group group= groupRepository.findByCode("customer");
        userEntity.addUserGroups(group);
    }

    @Override
    public boolean checkIfUserExist(String email) {
        return userRepository.findByEmail(email)!=null ? true : false;
    }

    @Override
    public void sendRegistrationConfirmationEmail(UserEntity user) {
        SecureToken secureToken= secureTokenService.createSecureToken();
        secureToken.setUser(user);
        secureTokenRepository.save(secureToken);
        AccountVerificationEmailContext emailContext = new AccountVerificationEmailContext();
        emailContext.init(user);
        emailContext.setToken(secureToken.getToken());
        emailContext.buildVerificationUrl(baseURL, secureToken.getToken());
        try {
            emailService.sendMail(emailContext);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean verifyUser(String token) throws InvalidTokenException {
        SecureToken secureToken = secureTokenService.findByToken(token);
        if(Objects.isNull(secureToken) || !StringUtils.equals(token, secureToken.getToken()) || secureToken.isExpired()){
            throw new InvalidTokenException("Token is not valid");
        }
        UserEntity user = userRepository.getOne(secureToken.getUser().getId());
        if(Objects.isNull(user)){
            return false;
        }
        user.setAccountVerified(true);
        userRepository.save(user); // let's same user details

        // we don't need invalid password now
        secureTokenService.removeToken(secureToken);
        return true;
    }

    @Override
    public UserEntity getUserById(String id) throws UnkownIdentifierException {
        UserEntity user= userRepository.findByEmail(id);
        if(user == null || BooleanUtils.isFalse(user.isAccountVerified())){
            // we will ignore in case account is not verified or account does not exists
            throw new UnkownIdentifierException("unable to find account or account is not active");
        }
        return user;
    }

    private void encodePassword(UserData source, UserEntity target){
        target.setPassword(passwordEncoder.encode(source.getPassword()));
    }


}
