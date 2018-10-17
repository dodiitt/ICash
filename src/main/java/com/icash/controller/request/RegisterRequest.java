package com.icash.controller.request;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class RegisterRequest implements Serializable {

    @NotNull
    @NotEmpty
    @ApiModelProperty(notes = "The user name for User", required = true, example = "Tuan le")
    private String username;

    @Email
    @ApiModelProperty(notes = "The email for User (It's must be a Email format)", required = true, example = "levantuan.itvn@gmail.com")
    private String email;

    @ApiModelProperty(notes = "The password for User (It's must be a Strong format])", required = true, example = "tuanle1.@.Com")
    private String password;

    @NotEmpty
    @ApiModelProperty(notes = "The gender for User", required = true, example = "[male, female]")
    private String gender;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
