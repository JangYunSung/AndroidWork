package com.lec.android.loginprofile;

import java.io.Serializable;

/**
 * Created by choi on 2017-05-08.
 */

public class MemberDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userID;
    private String userPassword;
    private String userName;
    private Integer userAge;


    public MemberDTO() {
    }

    public MemberDTO(String userID, String userPassword, String userName, Integer userAge) {
        this.userID = userID;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userAge = userAge;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "userID='" + userID + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userName='" + userName + '\'' +
                ", userAge=" + userAge +
                '}';
    }
}