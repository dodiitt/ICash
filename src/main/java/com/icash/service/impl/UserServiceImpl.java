package com.icash.service.impl;

import com.icash.entity.User;
import com.icash.exception.UserAlreadyExistException;
import com.icash.repository.UserRepository;
import com.icash.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(String id) {
        return null;
    }

    @Override
    public User loadUserByEmail(String email) {
        return this.userRepository.findUserByEmail(email);
    }

    @Override
    public boolean isUserExist(String email) {
        User user = this.loadUserByEmail(email);
        return user != null;
    }

    @Override
    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User registerNewUser(User user) throws UserAlreadyExistException {
        if(this.isUserExist(user.getEmail())){
            throw new UserAlreadyExistException("User already exist with email : " + user.getEmail());
        }
        return this.saveUser(user);
    }
}
