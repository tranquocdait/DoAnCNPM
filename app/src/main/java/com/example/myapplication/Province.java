package com.example.myapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Province {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nameProvince")
    @Expose
    private String nameProvince;

    public Province() {
    }


    public Province(Integer id, String nameProvince) {
        this.id = id;
        this.nameProvince = nameProvince;
    }

    public Integer getId() {
        return id;
    }

    public String getNameProvince() {
        return nameProvince;
    }

    public void setNameProvince(String nameProvince) {
        this.nameProvince = nameProvince;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
