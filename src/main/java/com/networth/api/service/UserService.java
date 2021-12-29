package com.networth.api.service;

import com.networth.api.entity.User;
import com.networth.api.enums.EStatusCode;
import com.networth.api.exception.ActionFailureException;
import com.networth.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public User addUser(User user) throws ActionFailureException {
        try {
            return userRepository.save(user);
        } catch (Exception ex) {
            throw new ActionFailureException(EStatusCode.ERROR_ON_ADD.name(), ex);
        }
    }

    public User resetPassword(User user) throws ActionFailureException {
        try {
            User saveUser = userRepository.getById(user.getId());
            saveUser.setPassword(user.getPassword());
            saveUser.setPasswordConfirm(user.getPasswordConfirm());
            return userRepository.save(saveUser);
        } catch (Exception ex) {
            throw new ActionFailureException(EStatusCode.ERROR_ON_UPDATE.name(), ex);
        }
    }

    public User forgetPassword(String userName) throws ActionFailureException {
        User saveUser = userRepository.findByUsername(userName);
        if (saveUser ==null)
        {
            throw new ActionFailureException(EStatusCode.ERROR_ON_ACCOUNT.name());
        }
        return saveUser;
    }

    public User login(User user) throws ActionFailureException{
        User saveUser = userRepository.findByUsername(user.getUsername());
        if (saveUser ==null || !user.getPassword().equals(saveUser.getPassword()))
        {
            throw new ActionFailureException(EStatusCode.ERROR_ON_LOGIN.name());
        }
        return saveUser;
    }
}
