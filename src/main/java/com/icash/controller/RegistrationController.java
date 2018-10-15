package com.icash.controller;

import com.icash.controller.request.RegisterRequest;
import com.icash.entity.User;
import com.icash.exception.UserAlreadyExistException;
import com.icash.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/public")
public class RegistrationController extends AbstractController{

    private static final Log LOGGER = LogFactory.getLog(RegistrationController.class);

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @PostMapping(value = "/users/register")
    @ResponseBody public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest registerRequest) throws UserAlreadyExistException {
        LOGGER.info("Begin register new user with email : " +  registerRequest.getEmail());
        User user = super.wrapUser(registerRequest);
        this.userService.registerNewUser(user);

        LOGGER.info("Register new user with email [{}] success." + registerRequest.getEmail());
        return new ResponseEntity<>(user.getEmail(), HttpStatus.CREATED);
    }

    @Override
    protected BCryptPasswordEncoder getBCryptPasswordEncoder() {
        return this.passwordEncoder;
    }
}
