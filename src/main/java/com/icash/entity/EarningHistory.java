package com.icash.entity;

import com.icash.icash_enum.EarningType;
import com.icash.icash_enum.OfferType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "earning_history")
public class EarningHistory {

    @Id
    private String id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "earning_title")
    private String earningTitle;

    @Column(name = "third_party_provider_name")
    private String thirdPartyProviderName;

    @Column(name = "icoins_earned")
    private Integer iCoinsEarned;

    @Column(name = "icoins_paid")
    private Integer iCoinsPaid;

    @Column(name = "time")
    private Date time;

    @Column(name = "device_name")
    private String deviceName;

    @Column(name = "offer_type")
    private OfferType offerType;

    @Column(name = "earning_type")
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

    public Integer getiCoinsEarned() {
        return iCoinsEarned;
    }

    public void setiCoinsEarned(Integer iCoinsEarned) {
        this.iCoinsEarned = iCoinsEarned;
    }

    public Integer getiCoinsPaid() {
        return iCoinsPaid;
    }

    public void setiCoinsPaid(Integer iCoinsPaid) {
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

    public String getEarningTitle() {
        return earningTitle;
    }

    public void setEarningTitle(String earningTitle) {
        this.earningTitle = earningTitle;
    }
}
