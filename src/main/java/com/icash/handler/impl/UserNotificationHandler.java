package com.icash.handler.impl;

import com.icash.configuration.model.NotificationMessageProperties;
import com.icash.handler.AbstractNotificationService;
import com.icash.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailException;
import org.springframework.mail.MailMessage;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("userNotificationHandler")
public class UserNotificationHandler extends AbstractNotificationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserNotificationHandler.class);

    @Autowired
    private MailSender javaMailSender;

    @Autowired
    private UserService userService;

    @Autowired
    @Qualifier(value = "activeUserProperties")
    private NotificationMessageProperties activeUserProperties;

    @Override
    public void notify(String userID, String message) {

    }

    @Override
    public void notifyActiveAccount(String email, String username, String code) {
        LOGGER.info("Begin send active code for user [{}]", email);
        try{
            String fullyMessage = String.format(this.activeUserProperties.getMessage(), username, email, code);

            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(this.activeUserProperties.getFrom());
            mailMessage.setTo(email);
            mailMessage.setSubject(this.activeUserProperties.getSubject());
            mailMessage.setText(fullyMessage);
            javaMailSender.send(mailMessage);
            LOGGER.info("Send active code for user [{}] success.", email);
        }catch (MailException e){
            LOGGER.error("Error while sending active code for user [{}], detail here : {}", email, e.getMessage());
            e.getStackTrace();
        }
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
