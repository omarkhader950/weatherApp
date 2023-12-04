package com.wetherapp.Model;

import com.google.gson.annotations.SerializedName;

public class Main {
    @SerializedName("temp")

    public   double temp;
    @SerializedName("feelsLike")

    public double feelsLike;
    @SerializedName("humidity")

    public int  humidity;

    public double getTemp() {
        return temp;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public int getHumidity() {
        return humidity;
    }
}
