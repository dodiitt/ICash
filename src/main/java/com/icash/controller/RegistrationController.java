package com.icash.controller;

import com.icash.controller.request.RegisterRequest;
import com.icash.controller.request.ResetPasswordRequest;
import com.icash.entity.User;
import com.icash.exception.*;
import com.icash.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class RegistrationController extends AbstractController{

    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    /**
     *
     * @param registerRequest
     * @return
     * @throws UserAlreadyExistException
     */
    @PostMapping(value = "/public/users/register")
    @ResponseBody public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest registerRequest) throws UserAlreadyExistException {
        LOGGER.info("Begin register new user with email : " +  registerRequest.getEmail());
        User user = super.wrapUser(registerRequest);
        this.userService.registerNewUser(user);

        LOGGER.info("Register new user with email [{}] success." + registerRequest.getEmail());
        return new ResponseEntity<>(user.getEmail(), HttpStatus.CREATED);
    }

    /**
     *
     * @param email
     * @param code
     * @throws UserNotFoundException
     * @throws ActiveCodeInvalid
     * @throws UserHasAlreadyActive
     */
    @GetMapping(value = "/public/users/active/{email}/{code}")
    @ResponseStatus(HttpStatus.OK)
    public void activeUser(@PathVariable String email, @PathVariable String code) throws UserNotFoundException, ActiveCodeInvalid, UserHasAlreadyActive {
        this.userService.activeUser(email, code);
    }

    /**
     *
     * @param email
     * @throws UserNotFoundException
     * @throws UserHasAlreadyActive
     */
    @GetMapping(value = "/public/users/active/resend-code/{email}")
    @ResponseStatus(HttpStatus.OK)
    public void resendActiveCode(@PathVariable String email) throws UserNotFoundException, UserHasAlreadyActive {
        this.userService.resendActiveCode(email);
    }

    /**
     *
     * @param email
     * @throws UserNotFoundException
     */
    @GetMapping(value = "/public/users/password/for-got/{email}")
    @ResponseStatus(HttpStatus.OK)
    public void forGotPassword(@PathVariable String email) throws UserNotFoundException {
        this.userService.forGotPassword(email);
    }

    /**
     *
     * @param resetPasswordRequest
     * @throws UserNotFoundException
     * @throws OldPasswordInvalidException
     */
    @PostMapping(value = "/protected/users/password/reset")
    @ResponseStatus(HttpStatus.OK)
    public void resetPassword(@Valid @RequestBody ResetPasswordRequest resetPasswordRequest) throws UserNotFoundException, OldPasswordInvalidException {
        this.userService.resetPassword(resetPasswordRequest);
    }

    /**
     *
     * @return
     */
    @Override
    protected BCryptPasswordEncoder getBCryptPasswordEncoder() {
        return this.passwordEncoder;
    }
}
