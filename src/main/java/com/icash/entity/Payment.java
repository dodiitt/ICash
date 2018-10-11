package com.icash.entity;

import com.icash.icash_enum.PaymentType;

public class Payment {

    private String id;

    private String userID;

    private String payPalEmail;

    private String bankName;

    private String cardNumber;

    private String expiredDay;

    private String expiredMonth;

    private String expiredYear;

    private PaymentType paymentType;

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

    public String getpayPalEmail() {
        return payPalEmail;
    }

    public void setpayPalEmail(String payPalEmail) {
        this.payPalEmail = payPalEmail;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiredDay() {
        return expiredDay;
    }

    public void setExpiredDay(String expiredDay) {
        this.expiredDay = expiredDay;
    }

    public String getExpiredMonth() {
        return expiredMonth;
    }

    public void setExpiredMonth(String expiredMonth) {
        this.expiredMonth = expiredMonth;
    }

    public String getExpiredYear() {
        return expiredYear;
    }

    public void setExpiredYear(String expiredYear) {
        this.expiredYear = expiredYear;
    }

    public String getPayPalEmail() {
        return payPalEmail;
    }

    public void setPayPalEmail(String payPalEmail) {
        this.payPalEmail = payPalEmail;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
}
