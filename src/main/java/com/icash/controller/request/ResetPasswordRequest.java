package com.icash.controller.request;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

public class ResetPasswordRequest implements Serializable {

    @NotEmpty
    @ApiModelProperty(notes = "The older User's password (It's must be a Strong format])", required = true, example = "tuanle1.@.Com")
    private String oldPassword;

    @NotEmpty
    @ApiModelProperty(notes = "The new password for User (It's must be a Strong format])", required = true, example = "tuanle1.@.Com")
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
