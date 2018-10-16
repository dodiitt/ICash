package com.icash.handler.impl;

import com.icash.configuration.message.MailMessageConfig;
import com.icash.handler.AbstractNotificationService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component("adminNotificationHandler")
public class AdminNotificationHandler extends AbstractNotificationService {

    private static final Log LOG = LogFactory.getLog(AdminNotificationHandler.class);

//    @Autowired
//    private MailSender javaMailSender;
//
//    @Autowired
//    private MailMessageConfig adminMailProperties;

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