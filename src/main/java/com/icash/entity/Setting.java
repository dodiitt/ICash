package com.icash.entity;

public class Setting {

    private Double minimumCash;

    private Double dailyBonus;

    private Double monthlyBonus;

    private Integer referenceFriendRequired;

    public Double getMinimumCash() {
        return minimumCash;
    }

    public void setMinimumCash(Double minimumCash) {
        this.minimumCash = minimumCash;
    }

    public Double getDailyBonus() {
        return dailyBonus;
    }

    public void setDailyBonus(Double dailyBonus) {
        this.dailyBonus = dailyBonus;
    }

    public Double getMonthlyBonus() {
        return monthlyBonus;
    }

    public void setMonthlyBonus(Double monthlyBonus) {
        this.monthlyBonus = monthlyBonus;
    }

    public Integer getReferenceFriendRequired() {
        return referenceFriendRequired;
    }

    public void setReferenceFriendRequired(Integer referenceFriendRequired) {
        this.referenceFriendRequired = referenceFriendRequired;
    }
}
