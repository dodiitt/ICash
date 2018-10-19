package com.icash.exception;

public class UserHasCreatedButNotActiveYetException extends Exception {
    public UserHasCreatedButNotActiveYetException(String message) {
        super(message);
    }
}
