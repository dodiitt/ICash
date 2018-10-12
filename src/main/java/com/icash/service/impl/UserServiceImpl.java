package com.icash.service.impl;

import com.icash.entity.User;
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
        return null;
    }

    @Override
    public boolean isUserExist(String email) {
        User user = this.loadUserByEmail(email);
        return user != null;
    }
}
