package com.wetherapp.Model;

import com.google.gson.annotations.SerializedName;

public class Weather {

    @SerializedName("main")
    String main;

    public String getMain() {
        return main;
    }
}
