package com.icash.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "lotto")
public class Lotto {

    @Id
    private String id;

    @Column(name = "user_id")
    private String userID;

    @Column(name = "betting_number")
    private Integer bettingNumber;

    @Column(name = "betting_icoins")
    private Integer bettingICoins;

    @Column(name = "betting_time")
    private Date bettingTime;

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

    public Integer getBettingNumber() {
        return bettingNumber;
    }

    public void setBettingNumber(Integer bettingNumber) {
        this.bettingNumber = bettingNumber;
    }

    public Integer getBettingICoins() {
        return bettingICoins;
    }

    public void setBettingICoins(Integer bettingICoins) {
        this.bettingICoins = bettingICoins;
    }

    public Date getBettingTime() {
        return bettingTime;
    }

    public void setBettingTime(Date bettingTime) {
        this.bettingTime = bettingTime;
    }
}
