package com.icash.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/public")
public class LogoutController {

    private static final Log LOGGER = LogFactory.getLog(LogoutController.class);

    @GetMapping(value = "/log-out")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void logout(HttpSession session){
        session.invalidate();
        LOGGER.info("User was log-out success.");
    }
}
