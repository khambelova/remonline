package com.example.habik.lineservice.OrderStatus;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class OrderDetails {

    @SerializedName("status")
    @Expose
    private Status status;

    @SerializedName("brand")
    @Expose
    private String brand;

    @SerializedName("model")
    @Expose
    private String model;

    @SerializedName("malfunction")
    @Expose
    private String malfunction;

    public Status getStatus() {
        return status;
    }

    public String getModel() {
        return model;
    }

    public String getMalfunction() {
        return malfunction;
    }
}
