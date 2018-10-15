package com.icash.entity;

import com.icash.icash_enum.SettingType;

public class Setting {

    private String id;

    private SettingType settingType;

    private Double minimumAmount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SettingType getSettingType() {
        return settingType;
    }

    public void setSettingType(SettingType settingType) {
        this.settingType = settingType;
    }

    public Double getMinimumAmount() {
        return minimumAmount;
    }

    public void setMinimumAmount(Double minimumAmount) {
        this.minimumAmount = minimumAmount;
    }

}
