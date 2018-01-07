package com.example.redissessionsample.domain;

import java.io.Serializable;

public class User implements Serializable {
    private String userName;
    private String gender;
    private String occupation;

    public User(String userName, String gender, String occupation) {
        this.userName = userName;
        this.gender = gender;
        this.occupation = occupation;
    }

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", gender='" + gender + '\'' +
                ", occupation='" + occupation + '\'' +
                '}';
    }
}

