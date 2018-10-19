package com.icash.controller;

import com.icash.controller.request.ForgotPasswordRequest;
import com.icash.controller.request.RegisterRequest;
import com.icash.controller.request.ResetPasswordRequest;
import com.icash.entity.User;
import com.icash.exception.*;
import com.icash.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Api(value = "Registration controller", description = "It's used to register and active a new account.")
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
    @ApiOperation(value = "Register new user", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully Registered new User"),
            @ApiResponse(code = 409, message = "Conflict (Email have already exist in the system.)"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")}
    )
    @ResponseBody public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest registerRequest) throws UserAlreadyExistException {
        LOGGER.info("Begin register new user with email : " +  registerRequest.getEmail());
        User user = super.wrapUser(registerRequest);
        this.userService.registerNewUser(user);

        LOGGER.info("Register new user with email [{}] success.", registerRequest.getEmail());
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
    @ApiOperation(value = "Active the user.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully active new User"),
            @ApiResponse(code = 400, message = "System not found with passing email"),
            @ApiResponse(code = 400, message = "The active code is invalid."),
            @ApiResponse(code = 400, message = "User has already active before.")}
    )
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
    @ApiOperation(value = "Resend the active code")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully resend new active code."),
            @ApiResponse(code = 400, message = "System not found with passing email"),
            @ApiResponse(code = 400, message = "User has already successfully active before.")}
    )
    public void resendActiveCode(@PathVariable String email) throws UserNotFoundException, UserHasAlreadyActive {
        this.userService.resendActiveCode(email);
    }

    /**
     *
     * @param request
     * @throws UserNotFoundException
     */
    @GetMapping(value = "/public/users/password/for-got")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "For-got password")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Processing the for-got password success."),
            @ApiResponse(code = 400, message = "System not found with passing email")}
    )
    public void forGotPassword(@Valid @RequestBody ForgotPasswordRequest request) throws UserNotFoundException {
        this.userService.forGotPassword(request.getEmail());
    }

    /**
     *
     * @param resetPasswordRequest
     * @throws UserNotFoundException
     * @throws OldPasswordInvalidException
     */
    @PostMapping(value = "/protected/users/password/reset")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Reset password")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully reset the password."),
            @ApiResponse(code = 400, message = "System not found with passing email"),
            @ApiResponse(code = 400, message = "Old password is incorrect.")}
    )
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
