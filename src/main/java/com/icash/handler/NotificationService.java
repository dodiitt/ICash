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
     * @param message
     */
    void notifyActiveAccount(String email, String message);

    /**
     *
     * @param email
     * @param newPassword
     */
    void notifyForgotPassword(String email, String newPassword);
}
