package com.bean;

import java.math.BigDecimal;
import java.util.Date;

public class User {
    private int userId;
    private String userName;
    private String useraccount;
    private String userpwd;
    private int role;
    private int state;
    private Date userinsertTime;

    public User() {
    }

    public User(int userId, String userName, String useraccount, String userpwd, int role, int state, Date userinsertTime) {
        this.userId = userId;
        this.userName = userName;
        this.useraccount = useraccount;
        this.userpwd = userpwd;
        this.role = role;
        this.state = state;
        this.userinsertTime = userinsertTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUseraccount() {
        return useraccount;
    }

    public void setUseraccount(String useraccount) {
        this.useraccount = useraccount;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getUserinsertTime() {
        return userinsertTime;
    }

    public void setUserinsertTime(Date userinsertTime) {
        this.userinsertTime = userinsertTime;
    }
}


