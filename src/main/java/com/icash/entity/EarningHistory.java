package com.icash.entity;

import com.icash.icash_enum.EarningType;
import com.icash.icash_enum.OfferType;

import java.util.Date;

public class EarningHistory {

    private String id;

    private String userId;

    private String thirdPartyProviderName;

    private Double iCoinsEarned;

    private Double iCoinsPaid;

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

    public Double getiCoinsEarned() {
        return iCoinsEarned;
    }

    public void setiCoinsEarned(Double iCoinsEarned) {
        this.iCoinsEarned = iCoinsEarned;
    }

    public Double getiCoinsPaid() {
        return iCoinsPaid;
    }

    public void setiCoinsPaid(Double iCoinsPaid) {
        this.iCoinsPaid = iCoinsPaid;
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
