package com.icash.controller.response;

import java.io.Serializable;
import java.util.Date;

public class RedeemHistoryResponse implements Serializable {

    private Double cashRedeem;

    private Integer iCoinsRedeem;

    private String paymentType;

    private Date time;

    public Double getCashRedeem() {
        return cashRedeem;
    }

    public void setCashRedeem(Double cashRedeem) {
        this.cashRedeem = cashRedeem;
    }

    public Integer getiCoinsRedeem() {
        return iCoinsRedeem;
    }

    public void setiCoinsRedeem(Integer iCoinsRedeem) {
        this.iCoinsRedeem = iCoinsRedeem;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
