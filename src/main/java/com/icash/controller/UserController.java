package com.icash.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/protected/api/v1/users")
public class UserController {

    @RequestMapping("/info/{id}")
    public ResponseEntity<?> getUserInfo(){

        return null;
    }
}
