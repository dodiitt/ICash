package com.icash.configuration.message;

import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class MailConfig {

//    @Bean
//    @ConfigurationProperties(prefix = "spring.mail")
//    private MailProperties mailProperties(){
//        return new MailProperties();
//    }
//
//    @Bean
//    public MailSender javaMailSender(MailProperties mailProperties){
//        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//
//        mailSender.setHost(mailProperties.getHost());
//        mailSender.setPort(mailProperties.getPort());
//        mailSender.setUsername(mailProperties.getUsername());
//        mailSender.setPassword(mailProperties.getPassword());
//        mailSender.setProtocol(mailProperties.getProtocol());
//
//        Properties properties = new Properties();
//        properties.putAll(mailProperties.getProperties());
//        mailSender.setJavaMailProperties(properties);
//
//        return mailSender;
//    }
//
//    @Bean(name = "adminMailProperties")
//    @ConfigurationProperties(prefix = "app.notify.mail.admin")
//    public MailMessageConfig adminMailProperties() {
//        return new MailMessageConfig();
//    }
}
