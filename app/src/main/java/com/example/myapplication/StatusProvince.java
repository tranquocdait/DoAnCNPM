package com.example.myapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StatusProvince {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private List<Province> data;

    public StatusProvince() {
        super();
    }

    public StatusProvince(String status, List<Province> data) {
        super();
        this.status = status;
        this.data = data;
    }

    public List<Province> getData() {
        return data;
    }

    public void setData(List<Province> data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
