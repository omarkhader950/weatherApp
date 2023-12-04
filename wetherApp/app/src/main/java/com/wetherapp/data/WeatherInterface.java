package com.wetherapp.data;

import com.wetherapp.Model.Model;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherInterface {

    @GET("weather?q=amman&appid=1e029e00cf0e82183bc01ef694b014e9")
    Observable<Model> getData();

    @GET("weather")
    Observable<Model> getCityData(@Query("q") String q , @Query("appid") String appid );

//?q=amman&appid=1e029e00cf0e82183bc01ef694b014e9

}
