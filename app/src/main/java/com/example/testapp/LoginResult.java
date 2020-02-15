package com.example.testapp;

import com.google.gson.annotations.SerializedName;

public class LoginResult {

    @SerializedName("auth-token")
    private String authToken;

    private String error;

    public String getAuthToken() {
        return authToken;
    }

    public String getError() {
        return error;
    }
}
