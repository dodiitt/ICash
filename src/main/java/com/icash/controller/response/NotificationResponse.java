package com.icash.controller.response;

import java.io.Serializable;
import java.util.Date;

public class NotificationResponse implements Serializable {

    private String subject;

    private String message;

    private Date time;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
