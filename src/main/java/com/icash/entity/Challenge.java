package com.icash.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "challenge")
public class Challenge {

    @Id
    private String id;

    @Column
    private String level;

    @Column(name = "total_icoins")
    private Integer totalICoins;

    @Column(name = "number_of_reference")
    private Integer numberOfReferenced;

    @Column(name = "daily_bonus")
    private Integer dailyBonus;

    @Column(name = "monthly_bonus")
    private Integer monthlyBonus;

    @Column(name = "yearly_bonus")
    private Integer yearlyBonus;

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

    public Integer getDailyBonus() {
        return dailyBonus;
    }

    public void setDailyBonus(Integer dailyBonus) {
        this.dailyBonus = dailyBonus;
    }

    public Integer getMonthlyBonus() {
        return monthlyBonus;
    }

    public void setMonthlyBonus(Integer monthlyBonus) {
        this.monthlyBonus = monthlyBonus;
    }

    public Integer getYearlyBonus() {
        return yearlyBonus;
    }

    public void setYearlyBonus(Integer yearlyBonus) {
        this.yearlyBonus = yearlyBonus;
    }
}
