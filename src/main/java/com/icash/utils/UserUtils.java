package com.icash.utils;

import com.icash.entity.User;
import com.icash.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserUtils {

    @Autowired
    private UserService userService;

    public User currentUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if(auth != null && auth.getPrincipal() instanceof UserDetails){
            String email = ((UserDetails) auth.getPrincipal()).getUsername();

            User user = this.userService.loadUserByEmail(email);
            if(user != null){
                return user;
            }
        }
        return null;
    }
}
