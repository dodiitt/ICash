package com.icash.handler.security;

import com.icash.entity.User;
import com.icash.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.loadUserByEmail(username);
        if(user == null){
            throw new UsernameNotFoundException("Username or password is invalid");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.getEnable(), true, true, true, null);
    }
}
