package com.icash.controller.response;

import java.io.Serializable;

public class UserInfoResponse implements Serializable {

    private String username;

    private Integer iCoins;

    private String avatar;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getiCoins() {
        return iCoins;
    }

    public void setiCoins(Integer iCoins) {
        this.iCoins = iCoins;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
