package com.icash.service;

import com.icash.entity.User;

public interface UserService {
    User getUserById(String id);
    User loadUserByEmail(String email);
}
