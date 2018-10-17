package com.icash.handler;

public interface NotificationService {
    /**
     *
     * @param userID
     * @param message
     */
    void notify(String userID, String message);

    /**
     *
     * @param email
     * @param username
     * @param code
     */
    void notifyActiveAccount(String email, String username, String code);

    /**
     *
     * @param email
     * @param newPassword
     */
    void notifyForgotPassword(String email, String newPassword);
}
