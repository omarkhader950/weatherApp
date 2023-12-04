package com.wetherapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Model {

    @SerializedName("main")
    Main main;

    public Main getMain() {
        return main;
    }

    public List<Weather> getWeathers() {
        return weathers;
    }

    @SerializedName("weather")
    List<Weather> weathers=null;

}