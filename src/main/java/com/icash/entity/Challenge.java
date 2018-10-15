package com.icash.entity;

public class Challenge {

    private String id;

    private String level;

    private Double totalICoins;

    private Integer numberOfReferenced;

    private Double dailyBonus;

    private Double monthlyBonus;

    private Double yearlyBonus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Double getTotalICoins() {
        return totalICoins;
    }

    public void setTotalICoins(Double totalICoins) {
        this.totalICoins = totalICoins;
    }

    public Integer getNumberOfReferenced() {
        return numberOfReferenced;
    }

    public void setNumberOfReferenced(Integer numberOfReferenced) {
        this.numberOfReferenced = numberOfReferenced;
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

    public Double getYearlyBonus() {
        return yearlyBonus;
    }

    public void setYearlyBonus(Double yearlyBonus) {
        this.yearlyBonus = yearlyBonus;
    }
}
