package com.bettkipchumba.java.model;

import java.sql.Date;

public class UserLogs {
    String username;
    String Timestamp;
    Date today;

    public UserLogs(String username, String timestamp, Date today) {
        this.username = username;
        Timestamp = timestamp;
        this.today = today;
    }

    public Date getToday() {
        return today;
    }

    public void setToday(Date today) {
        this.today = today;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(String timestamp) {
        Timestamp = timestamp;
    }
}
