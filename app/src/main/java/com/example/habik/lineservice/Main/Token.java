package com.example.habik.lineservice.Main;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Token {

    @SerializedName("api_key")
    @Expose
    private String api_key;

    @SerializedName("token")
    @Expose
    private String token;

    @SerializedName("success")
    @Expose
    private boolean success;

    public String getToken() {
        return token;
    }

    public String getApi_key() {
        return api_key;
    }

    public boolean isSuccess() {
        return success;
    }
}
