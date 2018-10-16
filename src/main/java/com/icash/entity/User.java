package com.icash.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "user_id")
    private String userID;

    @Column
    private String username;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private Boolean enable;

    @Column(name = "active_code")
    private String activeCode;

    @Column
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column
    private String gender;

    @Column(name = "current_icoins")
    private Integer currentICoins;

    @Column
    private String level;

    @Column(name = "reference_link")
    private String referenceLink;

    @Column(name = "reference_code")
    private String referenceCode;

    @Column(name = "total_icoins")
    private Integer totalICoins;

    @Column(name = "number_of_referenced")
    private Integer numberOfReferenced;

    @Column(name = "registration_time")
    private Date registrationTime;

    @Column(name = "avatar_image")
    private String avatarImage;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getReferenceLink() {
        return referenceLink;
    }

    public void setReferenceLink(String referenceLink) {
        this.referenceLink = referenceLink;
    }

    public String getReferenceCode() {
        return referenceCode;
    }

    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }

    public Integer getCurrentICoins() {
        return currentICoins;
    }

    public void setCurrentICoins(Integer currentICoins) {
        this.currentICoins = currentICoins;
    }

    public Integer getTotalICoins() {
        return totalICoins;
    }

    public void setTotalICoins(Integer totalICoins) {
        this.totalICoins = totalICoins;
    }

    public Integer getNumberOfReferenced() {
        return numberOfReferenced;
    }

    public void setNumberOfReferenced(Integer numberOfReferenced) {
        this.numberOfReferenced = numberOfReferenced;
    }

    public Date getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Date registrationTime) {
        this.registrationTime = registrationTime;
    }

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }

    public String getAvatarImage() {
        return avatarImage;
    }

    public void setAvatarImage(String avatarImage) {
        this.avatarImage = avatarImage;
    }
}
