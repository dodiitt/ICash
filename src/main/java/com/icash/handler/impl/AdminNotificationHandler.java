package com.icash.handler.impl;

import com.icash.configuration.model.MailMessageConfig;
import com.icash.handler.AbstractNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("adminNotificationHandler")
public class AdminNotificationHandler extends AbstractNotificationService {

    @Autowired
    private MailSender javaMailSender;

    @Autowired
    private MailMessageConfig adminMailProperties;

    @Override
    public void notify(String userID, String message) {

    }

    @Override
    public void notifyActiveAccount(String email, String username, String code) {

    }


    @Override
    public void notifyForgotPassword(String email, String newPassword) {

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
