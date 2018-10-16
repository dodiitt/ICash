package com.icash.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/protected")
public class LogoutController {

    private static final Log LOGGER = LogFactory.getLog(LogoutController.class);

    @GetMapping(value = "/log-out")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            session.invalidate();
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        LOGGER.info("User was log-out success.");
    }
}
