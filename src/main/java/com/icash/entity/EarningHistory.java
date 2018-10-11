package com.icash.entity;

import com.icash.icash_enum.EarningType;
import com.icash.icash_enum.OfferType;

import java.util.Date;

public class EarningHistory {

    private String id;

    private String userId;

    private String thirdPartyProviderName;

    private String cashEarned;

    private String cashPaid;

    private Date time;

    private String deviceName;

    private OfferType offerType;

    private EarningType earningType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getThirdPartyProviderName() {
        return thirdPartyProviderName;
    }

    public void setThirdPartyProviderName(String thirdPartyProviderName) {
        this.thirdPartyProviderName = thirdPartyProviderName;
    }

    public String getCashEarned() {
        return cashEarned;
    }

    public void setCashEarned(String cashEarned) {
        this.cashEarned = cashEarned;
    }

    public String getCashPaid() {
        return cashPaid;
    }

    public void setCashPaid(String cashPaid) {
        this.cashPaid = cashPaid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public OfferType getOfferType() {
        return offerType;
    }

    public void setOfferType(OfferType offerType) {
        this.offerType = offerType;
    }

    public EarningType getEarningType() {
        return earningType;
    }

    public void setEarningType(EarningType earningType) {
        this.earningType = earningType;
    }
}
