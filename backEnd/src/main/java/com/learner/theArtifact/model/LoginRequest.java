package com.learner.theArtifact.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("loginData")
public class LoginRequest {
    private String userName;
    private String password;

    public LoginRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public CharSequence getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
