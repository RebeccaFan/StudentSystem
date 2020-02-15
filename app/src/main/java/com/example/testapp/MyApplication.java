package com.example.testapp;

import android.app.Application;

public class MyApplication extends Application {

    private String authToken;

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}