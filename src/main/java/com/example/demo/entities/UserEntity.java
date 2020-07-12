package com.example.demo.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "User", schema = "dbo", catalog = "master")
public class UserEntity {

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
    private boolean approvedStatus;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "parkingOwnerUser")
    private Set<ParkingSpotsEntity> parkingSlots;


    @Basic
    @Column(name = "email", nullable = false, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_firstName", nullable = true, length = 255)
    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstname) {
        this.userFirstName = userFirstname;
    }

    @Basic
    @Column(name = "user_lastName", nullable = true, length = 255)
    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    @Basic
    @Column(name = "user_type", nullable = false, length = 10)
    public String getUserType() {
        return userType;
    }





    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "plate_number", nullable = false, length = 100)
    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    @Basic
    @Column(name = "oauth_token", nullable = false, length = 255)
    public String getOauthToken() {
        return oauthToken;
    }

    public void setOauthToken(String oauthToken) {
        this.oauthToken = oauthToken;
    }

    @Basic
    @Column(name = "session_webtoken", nullable = false, length = 255)
    public String getSessionWebtoken() {
        return sessionWebtoken;
    }

    public void setSessionWebtoken(String sessionWebtoken) {
        this.sessionWebtoken = sessionWebtoken;
    }

    @Basic
    @Column(name = "active_status", nullable = false)
    public boolean isActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }


    @Basic
    @Column(name = "approved_status", nullable = false)
    public boolean isApprovedStatus() {
        return approvedStatus;
    }

    public void setApprovedStatus(boolean approvedStatus) {
        this.approvedStatus = approvedStatus;
    }
    @Basic
    @Column(name = "CREATED_TIMESTAMP", nullable = false)
    public Timestamp getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Timestamp createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    @Basic
    @Column(name = "UPDATED_TIME", nullable = false)
    public Timestamp getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Timestamp updatedTime) {
        this.updatedTime = updatedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (userId != that.userId) return false;
        if (activeStatus != that.activeStatus) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (userFirstName != null ? !userFirstName.equals(that.userFirstName) : that.userFirstName != null)
            return false;
        if (userLastName != null ? !userLastName.equals(that.userLastName) : that.userLastName != null) return false;
        if (userType != null ? !userType.equals(that.userType) : that.userType != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (plateNumber != null ? !plateNumber.equals(that.plateNumber) : that.plateNumber != null) return false;
        if (oauthToken != null ? !oauthToken.equals(that.oauthToken) : that.oauthToken != null) return false;
        if (sessionWebtoken != null ? !sessionWebtoken.equals(that.sessionWebtoken) : that.sessionWebtoken != null)
            return false;
        if (createdTimestamp != null ? !createdTimestamp.equals(that.createdTimestamp) : that.createdTimestamp != null)
            return false;
        if (updatedTime != null ? !updatedTime.equals(that.updatedTime) : that.updatedTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (userFirstName != null ? userFirstName.hashCode() : 0);
        result = 31 * result + (userLastName != null ? userLastName.hashCode() : 0);
        result = 31 * result + (userType != null ? userType.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (plateNumber != null ? plateNumber.hashCode() : 0);
        result = 31 * result + (oauthToken != null ? oauthToken.hashCode() : 0);
        result = 31 * result + (sessionWebtoken != null ? sessionWebtoken.hashCode() : 0);
        result = 31 * result + (activeStatus ? 1 : 0);
        result = 31 * result + (createdTimestamp != null ? createdTimestamp.hashCode() : 0);
        result = 31 * result + (updatedTime != null ? updatedTime.hashCode() : 0);
        return result;
    }
}
