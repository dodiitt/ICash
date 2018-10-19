package com.icash.controller.commons;

import com.icash.exception.*;
import com.icash.model.ErrorMessage;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Api(value = "Advice controller", description = "It's used to handle exception and throw the friendly message for client.")
public class ControllerAdviceHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerAdviceHandler.class);

    @ExceptionHandler(value = UserAlreadyExistException.class)
    @ResponseBody
    public ResponseEntity<?> handlerUserAlreadyExist(UserAlreadyExistException ex){
        LOGGER.error(ex.getMessage());
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessage("Email already exist in system.");

        return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = ActiveCodeInvalid.class)
    @ResponseBody
    public ResponseEntity<?> handlerActiveCodeInvalid(ActiveCodeInvalid ex){
        LOGGER.error(ex.getMessage());
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessage("Your active code invalid.");

        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = UserHasAlreadyActive.class)
    @ResponseBody
    public ResponseEntity<?> handlerUserHasAlreadyActive(UserHasAlreadyActive ex){
        LOGGER.error(ex.getMessage());
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessage("Your account has already active before.");

        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST) ;
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    @ResponseBody
    public ResponseEntity<?> handlerUserNotFoundException(UserNotFoundException ex){
        LOGGER.error(ex.getMessage());
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessage("User not found.");

        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST) ;
    }

    @ExceptionHandler(value = OldPasswordInvalidException.class)
    @ResponseBody
    public ResponseEntity<?> handlerOldPasswordInvalidException(OldPasswordInvalidException ex){
        LOGGER.error(ex.getMessage());
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessage("Your current password is incorrect.");

        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST) ;
    }

    @ExceptionHandler(value = UserHasCreatedButNotActiveYetException.class)
    @ResponseBody
    public ResponseEntity<?> handlerUserHasCreatedButNotActiveYetException(UserHasCreatedButNotActiveYetException ex){
        LOGGER.error(ex.getMessage());
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessage("Your account had created before but not active yet.");

        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST) ;
    }
}
