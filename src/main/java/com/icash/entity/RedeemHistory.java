package com.icash.entity;

import com.icash.icash_enum.PaymentType;

import java.util.Date;

public class RedeemHistory {

    private String id;

    private String userID;

    private Double cashRedeem;

    private PaymentType paymentType;

    private Date time;

    private String deviceName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Double getCashRedeem() {
        return cashRedeem;
    }

    public void setCashRedeem(Double cashRedeem) {
        this.cashRedeem = cashRedeem;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
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
}
