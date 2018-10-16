package com.icash.service;

import com.icash.controller.request.ResetPasswordRequest;
import com.icash.entity.User;
import com.icash.exception.*;

public interface UserService {

    /**
     *
     * @param id
     * @return
     */
    User getUserById(String id);

    /**
     *
     * @param email
     * @return
     */
    User loadUserByEmail(String email);

    /**
     *
     * @param email
     * @return
     */
    boolean isUserExist(String email);

    /**
     *
     * @param user
     * @return
     */
    User saveUser(User user);

    /**
     *
     * @param user
     * @return
     * @throws UserAlreadyExistException
     */
    User registerNewUser(User user) throws UserAlreadyExistException;

    /**
     *
     * @param email
     * @param code
     * @throws UserNotFoundException
     * @throws ActiveCodeInvalid
     * @throws UserHasAlreadyActive
     */
    void activeUser(String email, String code) throws UserNotFoundException, ActiveCodeInvalid, UserHasAlreadyActive;

    /**
     *
     * @param email
     * @throws UserNotFoundException
     * @throws UserHasAlreadyActive
     */
    void resendActiveCode(String email) throws UserNotFoundException, UserHasAlreadyActive;

    /**
     *
     * @param email
     */
    void forGotPassword(String email) throws UserNotFoundException;

    void resetPassword(ResetPasswordRequest resetPasswordRequest) throws UserNotFoundException, OldPasswordInvalidException;
}
