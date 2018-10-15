package com.icash.controller;

import com.icash.exception.UserAlreadyExistException;
import com.icash.model.ErrorMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class AdviceControllerHandler {

    private static final Log LOGGER = LogFactory.getLog(AdviceControllerHandler.class);

    @ExceptionHandler(value = UserAlreadyExistException.class)
    @ResponseBody
    public ResponseEntity<?> handlerUserAlreadyExist(UserAlreadyExistException ex){
        LOGGER.error("New user was duplicate email from DB.");
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessage("Username already exist in system.");

        return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT) ;
    }
}
