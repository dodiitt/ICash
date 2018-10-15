package com.icash.controller;

import com.icash.controller.request.RegisterRequest;
import com.icash.entity.User;
import com.icash.icash_enum.Level;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Calendar;
import java.util.UUID;

public abstract class AbstractController {

    protected abstract BCryptPasswordEncoder getBCryptPasswordEncoder();

    protected User wrapUser(RegisterRequest registerRequest){
        User user = new User();

        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setGender(registerRequest.getGender());
        user.setPassword(this.getBCryptPasswordEncoder().encode(registerRequest.getPassword()));
        user.setLevel(String.valueOf(Level.LV_1.getValue()));
        user.setRegistrationTime(Calendar.getInstance().getTime());
        user.setUserID(UUID.randomUUID().toString());

        return user;
    }
}
