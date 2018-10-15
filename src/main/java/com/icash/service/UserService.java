package com.icash.service;

import com.icash.entity.User;
import com.icash.exception.UserAlreadyExistException;

public interface UserService {
    User getUserById(String id);
    User loadUserByEmail(String email);
    boolean isUserExist(String email);
    User saveUser(User user);
    User registerNewUser(User user) throws UserAlreadyExistException;
}
