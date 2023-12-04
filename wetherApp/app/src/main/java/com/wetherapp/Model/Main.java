package com.wetherapp.Model;

public class Main {



public double temp;


public double feelsLike;

public double tempMin;


public double tempMax;

    public double getTemp() {
        return temp;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public double getTempMin() {
        return tempMin;
    }

    public double getTempMax() {
        return tempMax;
    }



    public Main(double temp, double feelsLike, double tempMin, double tempMax) {
        this.temp = temp;
        this.feelsLike = feelsLike;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
    }






}
