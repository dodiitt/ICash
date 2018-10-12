package com.icash.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping(value = "/log-out")
    public void logOut(HttpServletRequest request, HttpServletResponse response){

    }

    @RequestMapping("/info/{id}")
    public ResponseEntity<?> getUserInfo(){

        return null;
    }
}
