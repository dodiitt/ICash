package com.icash.handler.impl;

import com.icash.handler.AbstractNotificationService;
import com.icash.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("userNotificationHandler")
public class UserNotificationHandler extends AbstractNotificationService {

    private static final Log LOG = LogFactory.getLog(UserNotificationHandler.class);

    @Autowired
    private MailSender javaMailSender;

    @Autowired
    private UserService userService;

    @Override
    public void notify(String userID, String message) {

    }

    @Override
    protected List<String> getRecipientsEmail(String userID) {
        return null;
    }

    @Override
    protected List<String> getCCEmail() {
        return null;
    }
}
