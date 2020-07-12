package com.example.demo.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class ParkingSpotsBean {
    private int id;
    private String name;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private boolean activeStatus;
    private int vacantSpots;
    private Timestamp createdTimestamp;
    private Timestamp updatedTime;
    private Object geoLocation;
    private int parking_user_id;

    public int getParking_user_id() {
        return parking_user_id;
    }

    public void setParking_user_id(int parking_user_id) {
        this.parking_user_id = parking_user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public boolean isActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    public int getVacantSpots() {
        return vacantSpots;
    }

    public void setVacantSpots(Integer vacantSpots) {
        this.vacantSpots = vacantSpots;
    }

    public Timestamp getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Timestamp createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public Timestamp getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Timestamp updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Object getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(Object geoLocation) {
        this.geoLocation = geoLocation;
    }
}
