package com.icash.controller.request;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

public class ResetPasswordRequest implements Serializable {

    @NotEmpty
    private String oldPassword;

    @NotEmpty
    private String newPassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
