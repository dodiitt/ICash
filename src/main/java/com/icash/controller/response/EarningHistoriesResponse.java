package com.icash.controller.response;

import java.io.Serializable;
import java.util.Date;

public class EarningHistoriesResponse implements Serializable {

    private String title;

    private Integer iCoinsEarned;

    private Date time;

    private String earningType;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getiCoinsEarned() {
        return iCoinsEarned;
    }

    public void setiCoinsEarned(Integer iCoinsEarned) {
        this.iCoinsEarned = iCoinsEarned;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getEarningType() {
        return earningType;
    }

    public void setEarningType(String earningType) {
        this.earningType = earningType;
    }
}
