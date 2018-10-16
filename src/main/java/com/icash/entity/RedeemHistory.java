package com.icash.entity;

import com.icash.icash_enum.PaymentType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "redeem_history")
public class RedeemHistory {

    @Id
    private String id;

    @Column(name = "user_id")
    private String userID;

    @Column(name = "cash_redeem")
    private Double cashRedeem;

    @Column(name = "icoins_redeem")
    private Integer iCoinsRedeem;

    @Column(name = "payment_type")
    private PaymentType paymentType;

    @Column(name = "pay_pal_email")
    private String payPalEmail;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "holder_name")
    private String holderName;

    @Column(name = "time")
    private Date time;

    @Column(name = "device_name")
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

    public Integer getiCoinsRedeem() {
        return iCoinsRedeem;
    }

    public void setiCoinsRedeem(Integer iCoinsRedeem) {
        this.iCoinsRedeem = iCoinsRedeem;
    }

    public String getPayPalEmail() {
        return payPalEmail;
    }

    public void setPayPalEmail(String payPalEmail) {
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

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }
}
