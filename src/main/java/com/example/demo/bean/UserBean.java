package com.example.demo.bean;

import java.sql.Timestamp;

public class UserBean {

    private String email;
    private int userId;
    private String userFirstName;
    private String userLastName;
    private String userType;
    private String password;
    private String plateNumber;
    private String oauthToken;
    private String sessionWebtoken;
    private boolean activeStatus;
    private Timestamp createdTimestamp;
    private Timestamp updatedTime;
    private boolean loginValid;
    private boolean isRegistered;
    private Exception exception;
    public String getEmail() {
        return email;
    }

    public void setLoginValid(boolean loginValid) {
        this.loginValid = loginValid;
    }

    public Exception getException() {
        return exception;
    }

    public void setRegistered(boolean registered) {
        isRegistered = registered;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public boolean isLoginValid() {
        return loginValid;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void setOauthToken(String oauthToken) {
        this.oauthToken = oauthToken;
    }

    public void setSessionWebtoken(String sessionWebtoken) {
        this.sessionWebtoken = sessionWebtoken;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    public void setCreatedTimestamp(Timestamp createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public void setUpdatedTime(Timestamp updatedTime) {
        this.updatedTime = updatedTime;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserType() {
        return userType;
    }

    public String getPassword() {
        return password;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getOauthToken() {
        return oauthToken;
    }

    public String getSessionWebtoken() {
        return sessionWebtoken;
    }

    public boolean isActiveStatus() {
        return activeStatus;
    }

    public Timestamp getCreatedTimestamp() {
        return createdTimestamp;
    }

    public Timestamp getUpdatedTime() {
        return updatedTime;
    }
}
