package com.icash.service.impl;

import com.icash.controller.request.ResetPasswordRequest;
import com.icash.entity.User;
import com.icash.exception.*;
import com.icash.handler.NotificationService;
import com.icash.repository.UserRepository;
import com.icash.service.UserService;
import com.icash.utils.UserUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    @Qualifier("userNotificationHandler")
    private NotificationService notificationService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserUtils userUtils;

    @Autowired
    private TaskExecutor taskExecutor;

    @Override
    public User getUserById(String id) {
        return this.userRepository.findOne(id);
    }

    @Override
    public User loadUserByEmail(String email) {
        return this.userRepository.findUserByEmail(email);
    }

    @Override
    public boolean isUserExist(String email) {
        User user = this.loadUserByEmail(email);
        return user != null;
    }

    @Override
    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User registerNewUser(User user) throws UserAlreadyExistException, UserHasCreatedButNotActiveYetException {
        User userInDB = this.loadUserByEmail(user.getEmail());
        if (userInDB == null) {
            String activeCode = generateActiveCode();

            taskExecutor.execute(() -> sendActiveCode(user.getEmail(), user.getUsername(), activeCode));

            user.setActiveCode(DigestUtils.md5Hex(activeCode));
            return this.saveUser(user);
        } else if (!userInDB.getEnable()) {
            LOGGER.error("User with email [{}] has already exist in system BUT not active yet.", user.getEmail());
            throw new UserHasCreatedButNotActiveYetException("User has already exist with email : " + user.getEmail() + " ,but not active!!");
        } else {
            LOGGER.error("User with email [{}] has already exist in system", user.getEmail());
            throw new UserAlreadyExistException("User already exist with email : " + user.getEmail());
        }
    }

    @Override
    public void activeUser(String email, String code) throws UserNotFoundException, ActiveCodeInvalid, UserHasAlreadyActive {
        LOGGER.info("Begin active user with email [{}]", email);
        User user = this.loadUserByEmail(email);
        if (user == null) {
            LOGGER.error("User not found with email [{}].", email);
            throw new UserNotFoundException("User not found with email : " + email);
        }
        if (!user.getEnable().equals(true)) {
            if (DigestUtils.md5Hex(code).equals(user.getActiveCode())) {
                user.setEnable(true);
                this.saveUser(user);
                LOGGER.info("User active success [{}] ", email);
            } else {
                LOGGER.error("Active user not success with invalid code [{}] ", code);
                throw new ActiveCodeInvalid("Invalid active code : " + code);
            }
        } else {
            throw new UserHasAlreadyActive("User is already active before.");
        }
    }

    @Override
    public void resendActiveCode(String email) throws UserNotFoundException, UserHasAlreadyActive {
        User user = this.loadUserByEmail(email);
        if (user == null) {
            LOGGER.error("User not found with email [{}].", email);
            throw new UserNotFoundException("User not found with email : " + email);
        }
        if (!user.getEnable().equals(true)) {
            String activeCode = generateActiveCode();

            sendActiveCode(email, user.getUsername(), activeCode);

            user.setActiveCode(DigestUtils.md5Hex(activeCode));
            this.saveUser(user);
            LOGGER.info("Resend active code success for user [{}] ", email);
        } else {
            throw new UserHasAlreadyActive("User is already active before");
        }
    }

    @Override
    public void forGotPassword(String email) throws UserNotFoundException {
        User user = this.loadUserByEmail(email);
        if (user == null) {
            LOGGER.error("User not found with email [{}] ", email);
            throw new UserNotFoundException("User not found with email : " + email);
        }
        String newPassword = this.generateNewPassword();

        this.taskExecutor.execute(() -> notificationService.notifyForgotPassword(email, newPassword));

        user.setPassword(passwordEncoder.encode(newPassword));
        this.saveUser(user);
        LOGGER.info("User [{}] has forgot password success.", email);
    }

    private String generateNewPassword() {
        return UUID.randomUUID().toString().substring(0, 6).toLowerCase();
    }

    @Override
    public void resetPassword(ResetPasswordRequest resetPasswordRequest) throws UserNotFoundException, OldPasswordInvalidException {
        User user = this.userUtils.currentUser();
        if (user == null) {
            LOGGER.error("User not found in current context holder.");
            throw new UserNotFoundException("User not found in current context holder.");
        }
        if (passwordEncoder.matches(resetPasswordRequest.getOldPassword(), user.getPassword())) {
            user.setPassword(passwordEncoder.encode(resetPasswordRequest.getNewPassword()));
            this.saveUser(user);
            LOGGER.info("User [{}] has reset password success.", user.getEmail());
        } else {
            throw new OldPasswordInvalidException("Old password in invalid.");
        }
    }

    private void sendActiveCode(String email, String username, String activeCode) {
        notificationService.notifyActiveAccount(email, username, activeCode);
    }

    private String generateActiveCode() {
        return UUID.randomUUID().toString().substring(0, 5).toLowerCase();
    }
}
